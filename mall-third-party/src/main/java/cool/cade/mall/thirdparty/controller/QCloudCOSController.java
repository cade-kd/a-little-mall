package cool.cade.mall.thirdparty.controller;

import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import cool.cade.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/thirdparty/cos")
public class QCloudCOSController {
//      可以写一个properties接收
    @Value("${qcloud.cos.bucket-name}")
    String bucketName;

    @Value("${qcloud.cos.region}")
    String region;

    @Value("${qcloud.cos.endpoint}")
    String endpoint;

    @Value("${qcloud.cos.secretId}")
    String secretId;
    @Value("${qcloud.cos.secretKey}")
    String secretKey;

    @Value("${qcloud.cos.credential.duration}")
    Integer duration;

//    @GetMapping(value = "/signature")
//    public R getQcloudCOSSinature(){
//        // 对象键(Key)是对象在存储桶中的唯一标识。
//        // 见https://cloud.tencent.com/document/product/436/13324
//        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        // 用户上传文件时指定的前缀。
//        String dir = "/mall/" + format + "/";
//        String key = dir + "${filename}";
//
//        QCloudCosPolicyHelper helper = new QCloudCosPolicyHelper()
//                .addExpireTime(5 * 60)
//                .addBucket(bucketName)
//                .addSignAlgorithm("sha1")
//                .addSecretId(secretId)
//                .addKeyPrefix(dir).build();
//
//        String keyTime = helper.getAttr("q-sign-time");
//        String encodedPolicy = "";
//        String signature = "";
//        try{
//            System.out.println(helper.getPolicyString());
//            encodedPolicy = helper.getEncodedPolicy();
//            signature = QCloudCosSignatureHelper.getCosSinature(helper, secretKey);
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("计算签名错误");
//            return R.error("计算签名错误");
//        }
//
//        Map<String, String> res = new HashMap<>();
//        res.put("q-sign-algorithm", helper.getAttr("q-sign-algorithm"));
//        res.put("key", key);
//        res.put("q-ak", secretId);
//        res.put("q-key-time", keyTime);
//        // 设置policy
//        res.put("policy", encodedPolicy);
//        // 设置签名
//        res.put("q-signature", signature);
////        res.put("success_action_status", "200");
//
//        return R.ok().put("data", res);
//    }

    @GetMapping("/credential")
    public R getCredential(){

        TreeMap<String, Object> config = new TreeMap<String, Object>();
        Map<String, Object> res = new HashMap<>();
        long currentTime = System.currentTimeMillis() / 1000;
        res.put("startTime", currentTime);
        res.put("expiredTime", currentTime + duration);
        res.put("region", region);
        res.put("bucket", bucketName);
        try {
            //这里的 SecretId 和 SecretKey 代表了用于申请临时密钥的永久身份（主账号、子账号等），子账号需要具有操作存储桶的权限。
            config.put("secretId", secretId);
            config.put("secretKey", secretKey);

            // 设置域名:
            // 如果您使用了腾讯云 cvm，可以设置内部域名
            //config.put("host", "sts.internal.tencentcloudapi.com");

            // 临时密钥有效时长，单位是秒，目前主账号最长 2 小时（即 7200 秒），子账号最长 36 小时（即 129600）秒
            config.put("durationSeconds", duration);
            config.put("bucket", bucketName);
            config.put("region", region);

            // 这里改成允许的路径前缀，可以根据自己网站的用户登录态判断允许上传的具体路径
            // 列举几种典型的前缀授权场景：
            // 1、允许访问所有对象："*"
            // 2、允许访问指定的对象："a/a1.txt", "b/b1.txt"
            // 3、允许访问指定前缀的对象："a*", "a/*", "b/*"
            // 如果填写了“*”，将允许用户访问所有资源；除非业务需要，否则请按照最小权限原则授予用户相应的访问权限范围。

            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            // 用户上传文件时指定的前缀。
            config.put("allowPrefixes", new String[] { "/mall/" + format + "/*" });

            res.put("allowPrefix", "/mall/" + format + "/");
            // 密钥的权限列表。必须在这里指定本次临时密钥所需要的权限。
            // 简单上传、表单上传和分块上传需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
            String[] allowActions = new String[] {
                    // 简单上传
                    "name/cos:PutObject",
                    // 表单上传、小程序上传
//                    "name/cos:PostObject",
//                    // 分块上传
//                    "name/cos:InitiateMultipartUpload",
//                    "name/cos:ListMultipartUploads",
//                    "name/cos:ListParts",
//                    "name/cos:UploadPart",
//                    "name/cos:CompleteMultipartUpload"
            };
            config.put("allowActions", allowActions);

            Response response = CosStsClient.getCredential(config);
            System.out.println(response.credentials.tmpSecretId);
            System.out.println(response.credentials.tmpSecretKey);
            System.out.println(response.credentials.sessionToken);

            Map<String,String>credentials = new HashMap<>();

            credentials.put("tmpSecretId", response.credentials.tmpSecretId);
            credentials.put("tmpSecretKey",response.credentials.tmpSecretKey);
            credentials.put("sessionToken",response.credentials.sessionToken);
            res.put("credentials", credentials);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("获取临时密钥异常！");
        }



        return R.ok().put("data", res);
    }
}
