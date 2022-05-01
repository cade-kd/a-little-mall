package cool.cade.mall.common.config.log;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class WebLogAbstract {

    private List<String> headers;
    public WebLogAbstract(){
        headers = new ArrayList<>();
    }

    public void addHeader(String header, String value) {
        headers.add(header + ":" + value);
    }


}
