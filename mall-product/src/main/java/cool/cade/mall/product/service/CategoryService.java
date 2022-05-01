package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.CategoryEntity;
import cool.cade.mall.product.vo.Catalogs2Vo;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:48
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 以树形结构查询所有分类
     *
     * @return
     */
    List<CategoryEntity> listWithTree();

    /**
     * 批量删除分类
     *
     * @param asList
     */
    void removeCategoryByIds(List<Long> asList);

    /**
     * 找到catelogId的完整路径；
     * [父/子/孙]
     *
     * @param catelogId
     * @return
     */
    Long[] findCatalogPath(Long catelogId);

    void updateCascade(CategoryEntity category);

    /**
     * 查找一级分类，首页显示
     *
     * @return
     */
    List<CategoryEntity> getLevel1Categories();

    /**
     * 查找二级、三级分类，首页显示
     *
     * @return
     */
    Map<String, List<Catalogs2Vo>> getCatalogJson();
}

