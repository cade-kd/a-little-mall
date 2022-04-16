package cool.cade.mall.coupon.dao;

import cool.cade.mall.coupon.entity.SmsMemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:32:01
 */
@Mapper
public interface SmsMemberPriceDao extends BaseMapper<SmsMemberPriceEntity> {
	
}
