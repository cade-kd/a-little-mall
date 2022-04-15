package cool.cade.mall.order.dao;

import cool.cade.mall.order.entity.OmsOrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:28:39
 */
@Mapper
public interface OmsOrderSettingDao extends BaseMapper<OmsOrderSettingEntity> {
	
}
