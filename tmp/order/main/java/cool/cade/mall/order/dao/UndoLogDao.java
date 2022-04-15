package cool.cade.mall.order.dao;

import cool.cade.mall.order.entity.UndoLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:28:38
 */
@Mapper
public interface UndoLogDao extends BaseMapper<UndoLogEntity> {
	
}
