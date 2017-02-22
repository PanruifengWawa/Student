package com.my.spring.serviceImpl;

import com.my.spring.DAO.CommentDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.CommentService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.CommentEntity;
import com.my.spring.model.UserEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nixinan on 2017/1/17.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;

    @Override
    public DataWrapper<Void> add(CommentEntity comment,String token) {
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        
        comment.setTime(new Timestamp(System.currentTimeMillis()));
        comment.setUserid(userEntity.getUserid());
        if(comment.getContents() != null && comment.getPostsid() != null && commentDao.add(comment))
        {
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> delete(Long commentid,String token) {
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        if(commentDao.delete(commentid)){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

	@Override
	public DataWrapper<List<CommentEntity>> getByPostsId(Integer numPerPage,Integer pageNum,Long postsId) {
		// TODO Auto-generated method stub
		
		return commentDao.getByPostId(numPerPage, pageNum, postsId);
	}
}
