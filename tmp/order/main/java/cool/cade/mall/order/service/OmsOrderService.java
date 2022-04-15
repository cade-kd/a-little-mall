package cool.cade.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.order.entity.OmsOrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:28:38
 */
public interface OmsOrderService extends IService<OmsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

