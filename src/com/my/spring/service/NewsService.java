package com.my.spring.service;
import com.my.spring.utils.DataWrapper;
import com.my.spring.model.NewsEntity;
import java.util.List;

/**
 * Created by nixinan on 2017/1/16.
 */
public interface NewsService {
    DataWrapper<Void> addNews(NewsEntity news,String token);
    DataWrapper<Void> updateNews(NewsEntity news);
    DataWrapper<Void> deleteNews(Long newsid,String token);
    DataWrapper<List<NewsEntity>> getNewsList(Integer numPerPage,Integer pageNum,String title, String starttime, String endtime, Long state);
    DataWrapper<NewsEntity> getNewsById(Long newsid);
    DataWrapper<Void> verify(Long newsid,Long state,String token);

}
