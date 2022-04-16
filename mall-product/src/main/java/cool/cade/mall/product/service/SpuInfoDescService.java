package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 23:56:11
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

