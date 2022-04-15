package cool.cade.mall.coupon.dao;

import cool.cade.mall.coupon.entity.SmsSeckillSkuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动商品关联
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:32:00
 */
@Mapper
public interface SmsSeckillSkuRelationDao extends BaseMapper<SmsSeckillSkuRelationEntity> {
	
}
