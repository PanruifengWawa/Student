package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.NewsDao;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.my.spring.model.NewsEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/1/16.
 */
@Repository
public class NewsDaoImpl extends BaseDao<NewsEntity> implements NewsDao {

    @Override
    public boolean add(NewsEntity news) {
        return save(news);
    }

    @Override
    public boolean delete(Long newsid) {
        return delete(get(newsid));
    }

    @Override
    public boolean verify(Long newsid, Long state) {
        Session session = getSession();
        String sql = "update news set state='" + state + "' where newsid=" + newsid;
        try {
        	Query query = session.createSQLQuery(sql);
            query.executeUpdate();
        } catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	return false;
		}
        
        return true;
    }

    @Override
    public boolean updateNews(NewsEntity news) {
        return update(news);
    }

    @Override
    public DataWrapper<List<NewsEntity>> getNewsList(Integer numPerPage,Integer pageNum,String title, String starttime, String endtime, Long state) {
        DataWrapper<List<NewsEntity>> retDataWrapper = new DataWrapper<List<NewsEntity>>();
        List<NewsEntity> ret = new ArrayList<NewsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(NewsEntity.class);
        if (numPerPage == null) {
			numPerPage = 10;
		}
        if (pageNum == null) {
			pageNum = 1;
		}
        criteria.setProjection(Projections.rowCount());
        int totalltemNum = ((Long) criteria.uniqueResult()).intValue();
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numPerPage);
        criteria.setProjection(null);
        if (numPerPage > 0 && pageNum > 0) {
            criteria.setMaxResults(numPerPage);
            criteria.setFirstResult((pageNum - 1) * numPerPage);
        }
        if (title != null) {
            criteria.add(Restrictions.like("title", title));
        }
        if (starttime != null || endtime != null) {
            if (starttime != null && endtime == null) {
                criteria.add(Restrictions.ge("time", Date.valueOf(starttime)));
            }
            if (starttime == null && endtime != null) {
                criteria.add(Restrictions.le("time", Date.valueOf(endtime)));
            }
            if (starttime != null & endtime != null) {
                criteria.add(Restrictions.between("time", Date.valueOf(starttime), Date.valueOf(endtime)));
            }
        }
        if (state != null) {
            criteria.add(Restrictions.eq("state", state));
        }
        retDataWrapper.setCurrentPage(pageNum);
        retDataWrapper.setNumberPerPage(numPerPage);
        retDataWrapper.setTotalPage(totalPageNum);
        retDataWrapper.setTotalNumber(totalltemNum);
        ret = criteria.list();
        retDataWrapper.setData(ret);
        /*DataWrapper<List<NewsEntity>> retDataWrapper = new DataWrapper<List<NewsEntity>>();
        List<NewsEntity> ret = new ArrayList<NewsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(NewsEntity.class);


        if (title != null) {
            criteria.add(Restrictions.like("title", title));
        }
        if (startTime != null || endTime != null) {
            if (startTime != null && endTime == null) {
                criteria.add(Restrictions.ge("time", Date.valueOf(startTime)));
            }
            if (startTime == null && endTime != null) {
                criteria.add(Restrictions.le("time", Date.valueOf(endTime)));
            }
            if (startTime != null & endTime != null) {
                criteria.add(Restrictions.between("time", Date.valueOf(startTime), Date.valueOf(endTime)));
            }
        }
        if (state != null) {
            criteria.add(Restrictions.eq("state", state));
        }
        ret = criteria.list();
        retDataWrapper.setData(ret);*/
        return retDataWrapper;
    }

    @Override
    public NewsEntity getNews(Long newsid) {
        return get(newsid);

    }
}
