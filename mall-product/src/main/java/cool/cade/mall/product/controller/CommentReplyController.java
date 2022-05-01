package cool.cade.mall.product.controller;

import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.R;
import cool.cade.mall.product.entity.CommentReplyEntity;
import cool.cade.mall.product.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 商品评价回复关系
 *
 * @author ander
 * @email cade@cade.cool
 * @date 2019-10-01 22:50:32
 */
@RestController
@RequestMapping("product/commentreply")
public class CommentReplyController {
    @Autowired
    private CommentReplyService commentReplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:commentreply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commentReplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:commentreply:info")
    public R info(@PathVariable("id") Long id){
		CommentReplyEntity commentReply = commentReplyService.getById(id);

        return R.ok().put("commentReply", commentReply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:commentreply:save")
    public R save(@RequestBody CommentReplyEntity commentReply){
		commentReplyService.save(commentReply);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:commentreply:update")
    public R update(@RequestBody CommentReplyEntity commentReply){
		commentReplyService.updateById(commentReply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:commentreply:delete")
    public R delete(@RequestBody Long[] ids){
		commentReplyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
