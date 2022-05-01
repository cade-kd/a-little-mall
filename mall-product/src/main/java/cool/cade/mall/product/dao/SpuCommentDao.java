package cool.cade.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.cade.mall.product.entity.SpuCommentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:49
 */
@Mapper
public interface SpuCommentDao extends BaseMapper<SpuCommentEntity> {

}
