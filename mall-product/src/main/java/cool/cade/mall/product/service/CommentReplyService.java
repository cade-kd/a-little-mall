package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.CommentReplyEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:48
 */
public interface CommentReplyService extends IService<CommentReplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

