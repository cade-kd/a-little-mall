package cool.cade.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.Query;
import cool.cade.mall.product.dao.CommentReplyDao;
import cool.cade.mall.product.entity.CommentReplyEntity;
import cool.cade.mall.product.service.CommentReplyService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("commentReplyService")
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyDao, CommentReplyEntity> implements CommentReplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommentReplyEntity> page = this.page(
                new Query<CommentReplyEntity>().getPage(params),
                new QueryWrapper<CommentReplyEntity>()
        );

        return new PageUtils(page);
    }

}
