package cool.cade.mall.ware.dao;

import cool.cade.mall.ware.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 *
 * @author Ander
 * @email cade@cade.cool
 * @date 2019-11-17 13:50:10
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {

}
