package cool.cade.mall.coupon.dao;

import cool.cade.mall.coupon.entity.SmsCouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:32:00
 */
@Mapper
public interface SmsCouponDao extends BaseMapper<SmsCouponEntity> {
	
}
