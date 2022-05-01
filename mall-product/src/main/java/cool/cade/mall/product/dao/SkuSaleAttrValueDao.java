package cool.cade.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.cade.mall.product.entity.SkuSaleAttrValueEntity;
import cool.cade.mall.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * sku销售属性&值
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:49
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

    List<SkuItemSaleAttrVo> getSaleAttrBySpuId(Long spuId);

    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}
