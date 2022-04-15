package cool.cade.mall.coupon.dao;

import cool.cade.mall.coupon.entity.SmsSeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:32:01
 */
@Mapper
public interface SmsSeckillSessionDao extends BaseMapper<SmsSeckillSessionEntity> {
	
}
