package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 23:56:11
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

