package cool.cade.mall.product.fallback;

import cool.cade.mall.common.exception.BizCodeEnum;
import cool.cade.mall.common.utils.R;
import cool.cade.mall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

/**
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 21:08:49
 **/
@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}
