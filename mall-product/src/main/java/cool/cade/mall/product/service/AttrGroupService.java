package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 23:56:11
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

