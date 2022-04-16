package cool.cade.mall.ware.dao;

import cool.cade.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:26:22
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
