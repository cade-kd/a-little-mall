package cool.cade.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.cade.mall.product.entity.AttrGroupEntity;
import cool.cade.mall.product.vo.SpuItemAttrGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性分组
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:49
 */
@Mapper
public interface AttrGroupDao extends BaseMapper<AttrGroupEntity> {

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(@Param("spuId") Long spuId, @Param("catalogId") Long catalogId);
}
