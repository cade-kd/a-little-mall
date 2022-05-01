package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.AttrGroupEntity;
import cool.cade.mall.product.vo.AttrGroupWithAttrsVo;
import cool.cade.mall.product.vo.SpuItemAttrGroupVo;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:49
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    /**
     * 分页查询属性分组三级分类
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 分页查询属性分组三级分类
     * @param params
     * @param catelogId 分类id
     * @return
     */
    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}

