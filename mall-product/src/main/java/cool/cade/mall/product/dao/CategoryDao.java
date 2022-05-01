package cool.cade.mall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.cade.mall.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:48
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

}
