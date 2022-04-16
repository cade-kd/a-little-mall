package cool.cade.mall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.Query;

import cool.cade.mall.coupon.dao.SmsCouponHistoryDao;
import cool.cade.mall.coupon.entity.SmsCouponHistoryEntity;
import cool.cade.mall.coupon.service.SmsCouponHistoryService;


@Service("smsCouponHistoryService")
public class SmsCouponHistoryServiceImpl extends ServiceImpl<SmsCouponHistoryDao, SmsCouponHistoryEntity> implements SmsCouponHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsCouponHistoryEntity> page = this.page(
                new Query<SmsCouponHistoryEntity>().getPage(params),
                new QueryWrapper<SmsCouponHistoryEntity>()
        );

        return new PageUtils(page);
    }

}