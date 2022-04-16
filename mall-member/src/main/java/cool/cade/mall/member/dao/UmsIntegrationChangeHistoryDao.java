package cool.cade.mall.member.dao;

import cool.cade.mall.member.entity.UmsIntegrationChangeHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分变化历史记录
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:30:53
 */
@Mapper
public interface UmsIntegrationChangeHistoryDao extends BaseMapper<UmsIntegrationChangeHistoryEntity> {
	
}
