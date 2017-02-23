package com.my.spring.service;

import com.my.spring.utils.DataWrapper;

import java.util.List;

import com.my.spring.model.CommentEntity;
import com.my.spring.model.CommentReplyEntity;
/**
 * Created by nixinan on 2017/1/17.
 */
public interface CommentService {
    DataWrapper<Void> add(CommentEntity comment,String token);
    DataWrapper<Void> delete(Long commentid,String token);
    DataWrapper<List<CommentEntity>> getByPostsId(Integer numPerPage,Integer pageNum,Long postsId);
    
    DataWrapper<Void> replyComment(CommentReplyEntity commentReplyEntity,String token);
    DataWrapper<Void> deleteReplyComment(Long commentReplyId,String token);
}
