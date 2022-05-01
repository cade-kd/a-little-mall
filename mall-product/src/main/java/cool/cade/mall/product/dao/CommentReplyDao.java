package cool.cade.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.cade.mall.product.entity.CommentReplyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:48
 */
@Mapper
public interface CommentReplyDao extends BaseMapper<CommentReplyEntity> {

}
