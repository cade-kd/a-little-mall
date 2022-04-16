package cool.cade.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.coupon.entity.SmsMemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:32:01
 */
public interface SmsMemberPriceService extends IService<SmsMemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

