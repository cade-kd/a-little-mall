package cool.cade.mall.common.config.log;

import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

@Data
public class WebResponseLog  extends WebLogAbstract{

    private Integer status;


    public WebResponseLog(){

    }


    public static WebResponseLog fromResponse(HttpServletResponse response) {

        WebResponseLog webResponseLog = new WebResponseLog();
        webResponseLog.setStatus(response.getStatus());
        Stream<String> headers = response.getHeaderNames().stream();
        headers.forEach((header)->{
            webResponseLog.addHeader(header, response.getHeader(header));
        });
        webResponseLog.setStatus(response.getStatus());

        return webResponseLog;
    }
}
