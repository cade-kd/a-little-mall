package cool.cade.mall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.Query;

import cool.cade.mall.coupon.dao.SmsSpuBoundsDao;
import cool.cade.mall.coupon.entity.SmsSpuBoundsEntity;
import cool.cade.mall.coupon.service.SmsSpuBoundsService;


@Service("smsSpuBoundsService")
public class SmsSpuBoundsServiceImpl extends ServiceImpl<SmsSpuBoundsDao, SmsSpuBoundsEntity> implements SmsSpuBoundsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsSpuBoundsEntity> page = this.page(
                new Query<SmsSpuBoundsEntity>().getPage(params),
                new QueryWrapper<SmsSpuBoundsEntity>()
        );

        return new PageUtils(page);
    }

}