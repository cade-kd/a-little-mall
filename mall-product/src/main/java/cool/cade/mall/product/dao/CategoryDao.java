package cool.cade.mall.product.dao;

import cool.cade.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 23:56:11
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
