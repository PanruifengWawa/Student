package com.my.spring.controller;

import com.my.spring.service.CommentService;
import com.my.spring.utils.DataWrapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.my.spring.model.CommentEntity;
import com.my.spring.model.CommentReplyEntity;
/**
 * Created by nixinan on 2017/1/17.
 */
@Controller
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value="add",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute CommentEntity commentEntity,
            @RequestParam(value = "token",required = false) String token)
    {

        return commentService.add(commentEntity,token);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "commentid",required = false) Long commentid,
            @RequestParam(value = "token",required = false) String token)
    {

        return commentService.delete(commentid,token);
    }
    @RequestMapping(value="getbypostsid")
    @ResponseBody
    public DataWrapper<List<CommentEntity>> getByPostsId(
    		@RequestParam(value = "numperpage",required = false) Integer numPerPage,
            @RequestParam(value = "pagenum",required = false) Integer pageNum,
            @RequestParam(value = "postsid",required = true) Long postsId)
    {

        return commentService.getByPostsId(numPerPage,pageNum,postsId);
    }
    
    
    @RequestMapping(value="replyComment",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> replyComment(
            @ModelAttribute CommentReplyEntity commentReplyEntity,
            @RequestParam(value = "token",required = false) String token) {

        return commentService.replyComment(commentReplyEntity, token);
    }
    
    @RequestMapping(value="deleteReplyComment",method= RequestMethod.GET)
    @ResponseBody
    public DataWrapper<Void> deleteReplyComment(
    		@RequestParam(value = "commentreplyid",required = true) Long commentReplyId,
            @RequestParam(value = "token",required = false) String token) {

        return commentService.deleteReplyComment(commentReplyId, token);
    }
}
