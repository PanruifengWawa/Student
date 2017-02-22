package com.my.spring.DAO;
import com.my.spring.utils.DataWrapper;
import com.my.spring.model.NewsEntity;
import java.util.List;
/**
 * Created by nixinan on 2017/1/16.
 */
public interface NewsDao {
    boolean add(NewsEntity news);
    boolean delete(Long newsid);
    boolean verify(Long newsid,Long state);
    boolean updateNews(NewsEntity news);
    DataWrapper<List<NewsEntity>> getNewsList(Integer numPerPage,Integer pageNum,String title, String starttime,String endtime,Long state);
    NewsEntity getNews(Long newsid);
}
