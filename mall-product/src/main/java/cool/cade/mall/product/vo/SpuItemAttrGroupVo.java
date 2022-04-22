package cool.cade.mall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author: cade
 * @createTime: 2020-06-19 18:18
 **/

@Data
@ToString
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<Attr> attrs;

}
