package com.my.spring.DAO;

import java.util.List;

import com.my.spring.model.CommentReplyEntity;

public interface CommentReplyDao {
	boolean addCommentReply(CommentReplyEntity commentReplyEntity);
	boolean deleteCommentReply(Long commentReplyId);
	List<CommentReplyEntity> getByCommentId(Long commentId);
}
