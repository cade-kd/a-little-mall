package cool.cade.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.order.entity.MqMessageEntity;

import java.util.Map;

/**
 * 
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:28:38
 */
public interface MqMessageService extends IService<MqMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

