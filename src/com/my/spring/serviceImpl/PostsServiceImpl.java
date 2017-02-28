package com.my.spring.serviceImpl;

import com.my.spring.DAO.PostsDao;
import com.my.spring.DAO.UserDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.PostsService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.PostsEntity;
import com.my.spring.model.UserEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nixinan on 2017/1/17.
 */
@Service("postsService")
public class PostsServiceImpl implements PostsService{
    @Autowired
    PostsDao postsDao;
    @Autowired
    UserDao userDao;


    @Override
    public DataWrapper<Void> add(PostsEntity posts,String token) {
        posts.setTime(new Timestamp(System.currentTimeMillis()));
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        posts.setUserid(userEntity.getUserid());
        posts.setReadcount(new Long(0));
        posts.setState(0);
        if(posts.getTitle() != null && posts.getContents() != null && postsDao.add(posts))
        {
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> delete(Long postsId,String token) {
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        if(postsId != null && postsDao.delete(postsId)){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<PostsEntity> getPostsById(Long postsId) {
        DataWrapper<PostsEntity> retDataWrapper = new DataWrapper<PostsEntity>();

        if(postsId != null ) {

            PostsEntity postsEntity = postsDao.getPosts(postsId);
            postsDao.readPost(postsId);
            UserEntity userEntity = userDao.getUserById(postsEntity.getUserid());
            postsEntity.setUsername(userEntity.getUsername());
            retDataWrapper.setData(postsEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<List<PostsEntity>> getPostsList(Integer numPerPage,Integer pageNum,String theme, String title, String startTime, String endTime,Integer state) {
        return postsDao.getPostsList(numPerPage,pageNum,theme,title,startTime,endTime,state);
    }

	@Override
	public DataWrapper<Void> verify(Long postsid, Long state, String token) {
		// TODO Auto-generated method stub
		DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        
        
        if(postsid!=null&&state!=null)
        {
            if(postsDao.verify(postsid,state))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);

        return retDataWrapper;
	}
}
