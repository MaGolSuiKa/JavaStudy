package com.geekaca.newsproject.controller;


import com.geekaca.newsproject.service.CommentService;
import com.geekaca.newsproject.utils.PageBean;
import com.geekaca.newsproject.utils.Result;
import com.geekaca.newsproject.utils.ResultCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/comments/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        Object page = params.get("page");
        Object limit = params.get("limit");
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultCode.genFailResult("参数异常");
        }
        //string -> Integer

        PageBean pageBean = new PageBean();
        int intPageNo = Integer.parseInt(page.toString());
        int intLimit = Integer.parseInt(limit.toString());
        int start = (intPageNo - 1) * intLimit;
        pageBean.setPageNo(start);
        pageBean.setPageSize(intLimit);

        return ResultCode.genSuccessResult(commentService.getCommentsPage(pageBean));
    }

    /**
     * 审核 评论
     * @param ids  多条评论的id
     * @return
     */
    @PostMapping("/comments/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultCode.genFailResult("参数异常");
        }
        if (commentService.checkDone(ids)) {
            return ResultCode.genSuccessResult();
        } else {
            return ResultCode.genFailResult("审核失败");
        }
    }

    @PostMapping("/comments/reply")
    @ResponseBody
    public Result checkDone(@RequestParam("commentId") Long commentId,
                            @RequestParam("replyBody") String replyBody) {
        if (commentId == null || commentId < 1 || !StringUtils.hasText(replyBody)) {
            return ResultCode.genFailResult("参数异常");
        }
        if (commentService.reply(commentId, replyBody)) {
            return ResultCode.genSuccessResult();
        } else {
            return ResultCode.genFailResult("回复失败");
        }
    }

   @PostMapping("/comments/delete")
   @ResponseBody
   public Result delete(@RequestBody Integer[] ids) {
        return ResultCode.genSuccessResult();
   }

    @GetMapping("/comments")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }


}
