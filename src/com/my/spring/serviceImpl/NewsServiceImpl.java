package com.my.spring.serviceImpl;

import com.my.spring.DAO.NewsDao;
import com.my.spring.enums.CallStatusEnum;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.NewsService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.NewsEntity;
import com.my.spring.model.UserEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nixinan on 2017/1/16.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public DataWrapper<Void> addNews(NewsEntity news,String token) {
        news.setTime(new Timestamp(System.currentTimeMillis()));
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        news.setUserid(userEntity.getUserid());
        news.setState(new Long(0));
        if(news.getTitle() != null && news.getContents() != null &&  newsDao.add(news)){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> updateNews(NewsEntity news) {
        return null;
    }

    @Override
    public DataWrapper<Void> deleteNews(Long newsid,String token) {
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        
        if(newsDao.delete(newsid)){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<List<NewsEntity>> getNewsList(Integer numPerPage,Integer pageNum,String title, String Starttime, String endtime, Long state) {
        return newsDao.getNewsList(numPerPage,pageNum,title,Starttime,endtime,state);
    }

    @Override
    public DataWrapper<NewsEntity> getNewsById(Long newsid) {
        DataWrapper<NewsEntity> retDataWrapper = new DataWrapper<NewsEntity>();

        if(newsid != null ) {

            NewsEntity newsEntity = newsDao.getNews(newsid);
            retDataWrapper.setData(newsEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> verify(Long newsid, Long state,String token) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        
        
        if(newsid!=null&&state!=null)
        {
            if(newsDao.verify(newsid,state))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);

        return retDataWrapper;
    }
}
