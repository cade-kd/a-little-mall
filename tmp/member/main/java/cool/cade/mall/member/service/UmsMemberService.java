package cool.cade.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.member.entity.UmsMemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2022-04-15 18:30:53
 */
public interface UmsMemberService extends IService<UmsMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

