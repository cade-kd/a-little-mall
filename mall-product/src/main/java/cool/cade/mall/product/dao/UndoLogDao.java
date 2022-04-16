package cool.cade.mall.product.dao;

import cool.cade.mall.product.entity.UndoLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 23:56:11
 */
@Mapper
public interface UndoLogDao extends BaseMapper<UndoLogEntity> {
	
}
