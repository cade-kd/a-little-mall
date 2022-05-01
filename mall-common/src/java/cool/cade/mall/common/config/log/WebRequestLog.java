package cool.cade.mall.common.config.log;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Data
public class WebRequestLog extends WebLogAbstract{


    private String requestUri;

    private String queryString;

    private Map<String, String[]> params;

    private String method;


    public WebRequestLog(){

    }

    public static WebRequestLog fromRequest(HttpServletRequest request) {
        WebRequestLog webRequestLog = new WebRequestLog();


        Enumeration<String> headerNames = request.getHeaderNames();
        //使用循环遍历请求头，并通过getHeader()方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            webRequestLog.addHeader(headerName, request.getHeader(headerName));

        }
        webRequestLog.setRequestUri(request.getRequestURI());
        webRequestLog.setQueryString(request.getQueryString());
        webRequestLog.setMethod(request.getMethod());
        webRequestLog.setParams(request.getParameterMap());

        return webRequestLog;
    }
}
