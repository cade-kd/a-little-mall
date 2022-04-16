package cool.cade.mall.member.dao;

import cool.cade.mall.member.entity.UmsMemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:30:53
 */
@Mapper
public interface UmsMemberLoginLogDao extends BaseMapper<UmsMemberLoginLogEntity> {
	
}
