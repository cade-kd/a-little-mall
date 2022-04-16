package cool.cade.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.coupon.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:32:00
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

