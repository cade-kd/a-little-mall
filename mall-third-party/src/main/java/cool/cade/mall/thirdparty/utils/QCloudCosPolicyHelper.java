package cool.cade.mall.thirdparty.utils;

import org.apache.commons.codec.binary.Base64;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class QCloudCosPolicyHelper {

    final long EXIPERTIME = 60;
    private String endTimestampStr;

    private Map<String,String> attrs = new HashMap<>();
    private Map<String,String> prefix = new HashMap<>();
    private int minContentLen = -1;
    private int maxContentLen = -1;

    private String policy;
    private String encodedPolicy;

    public QCloudCosPolicyHelper addExpireTime(long second){
        long startTimestamp = System.currentTimeMillis() / 1000;
        long endTimestamp = startTimestamp +  second;
        String keyTime = startTimestamp + ";" + endTimestamp;
        this.endTimestampStr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(endTimestamp * 1000);
        attrs.put("q-sign-time", keyTime);
        return this;
    }

    public QCloudCosPolicyHelper addACL(String acl) {
        attrs.put("acl", acl);
        return this;
    }

    public QCloudCosPolicyHelper addACLPrefix(String aclPrefix) {
        prefix.put("acl", aclPrefix);
        return this;
    }

    public QCloudCosPolicyHelper addBucket(String bucket) {
        attrs.put("bucket", bucket);
        return this;
    }

    public QCloudCosPolicyHelper addSignAlgorithm(String algorithm) {
        attrs.put("q-sign-algorithm", algorithm);
        return this;
    }


    public QCloudCosPolicyHelper setContentLengthRange(int minNum, int maxNum ) {
        this.minContentLen = minNum;
        this.maxContentLen = maxNum;
        return this;
    }

    public QCloudCosPolicyHelper addKey(String key) {
        attrs.put("key", key);
        return this;
    }

    public QCloudCosPolicyHelper addKeyPrefix(String keyPrefix) {
        prefix.put("key", keyPrefix);
        return this;
    }

    public QCloudCosPolicyHelper addSecretId(String secretId) {
        attrs.put("q-ak", secretId);
        return this;
    }

    private void calPolicyString(){
        if(endTimestampStr == null) this.addExpireTime(this.EXIPERTIME);
        StringBuilder policy = new StringBuilder();
        policy.append("{\n" +
                "    \"expiration\": \"" + endTimestampStr + "\",\n" +
                "    \"conditions\": [\n");

        int len = attrs.size() + prefix.size() + (maxContentLen != -1 ? 1 : 0);
        for(Map.Entry<String, String> item : attrs.entrySet()) {
            policy.append("        { \""+ item.getKey() +"\": \"" + item.getValue() + "\" }");
            if(--len != 0) policy.append(",\n");
            else policy.append('\n');
        }

        for(Map.Entry<String, String> item : prefix.entrySet()) {
            policy.append("        [ \"starts-with\", \"$" + item.getKey() + "\",\"" + item.getValue() +  "\" ]");
            if(--len != 0) policy.append(",\n");
            else policy.append('\n');
        }

        if(maxContentLen != -1) {
            policy.append("        [ \"content-length-range\","+minContentLen + "," + maxContentLen + "]\n");
        }

        policy.append("    ]\n}");
        this.policy = policy.toString();
        encodedPolicy = new String(Base64.encodeBase64(this.policy.getBytes()));

    }

    public QCloudCosPolicyHelper build() {
        if(this.policy != null) {
            System.err.println("不能重复build");
            throw new IllegalStateException("can not build twice!");
        }
        calPolicyString();
        return this;
    }


    public String getPolicyString() throws IllegalAccessException {
        if(policy == null) {
            throw new IllegalAccessException("please build first!");
        }
        return policy;
    }

    public String getEncodedPolicy() throws IllegalAccessException {
        if(policy == null) {
            throw new IllegalAccessException("please build first!");
        }
        return encodedPolicy;
    }

    public String getAttr(String key) {
        return attrs.get(key);
    }

}
