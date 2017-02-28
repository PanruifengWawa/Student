package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.PostsDao;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.my.spring.model.PostsEntity;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/1/17.
 */
@Repository
public class PostsDaoImpl extends BaseDao<PostsEntity> implements PostsDao{
    @Override
    public boolean add(PostsEntity posts) {
        return save(posts);
    }

    @Override
    public boolean delete(Long postsId) {
        return delete(get(postsId));
    }

    @Override
    public DataWrapper<List<PostsEntity>> getPostsList(Integer numPerPage,Integer pageNum,String theme, String title, String startTime, String endTime,Integer state) {
        DataWrapper<List<PostsEntity>> retDataWrapper = new DataWrapper<List<PostsEntity>>();
        List<PostsEntity> ret = new ArrayList<PostsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(PostsEntity.class);
        if (numPerPage == null) {
			numPerPage = 10;
		}
        if (pageNum == null) {
			pageNum = 1;
		}
        if (numPerPage > 0 && pageNum > 0) {
            criteria.setMaxResults(numPerPage);
            criteria.setFirstResult((pageNum - 1) * numPerPage);
        }
        if (theme != null) {
            criteria.add(Restrictions.like("theme", theme));
        }
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
        
        
        criteria.setProjection(Projections.rowCount());
        int totalltemNum = ((Long) criteria.uniqueResult()).intValue();
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numPerPage);
        criteria.setProjection(null);
        
        
        
        retDataWrapper.setCurrentPage(pageNum);
        retDataWrapper.setNumberPerPage(numPerPage);
        retDataWrapper.setTotalPage(totalPageNum);
        retDataWrapper.setTotalNumber(totalltemNum);
        ret = criteria.list();
        retDataWrapper.setData(ret);
       /* DataWrapper<List<PostsEntity>> retDataWrapper = new DataWrapper<List<PostsEntity>>();
        List<PostsEntity> ret = new ArrayList<PostsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(PostsEntity.class);
        if(theme!=null)
        {
            criteria.add(Restrictions.like("theme", theme));
        }
        if(title!=null)
        {
            criteria.add(Restrictions.like("title",title));
        }
        if(startTime!=null||endTime!=null) {
            if(startTime!=null&&endTime==null)
            {
                criteria.add(Restrictions.ge("time", Date.valueOf(startTime)));
            }
            if(startTime==null&&endTime!=null){
                criteria.add(Restrictions.le("time",Date.valueOf(endTime)));
            }
            if(startTime!=null&endTime!=null)
            {
                criteria.add(Restrictions.between("time",Date.valueOf(startTime),Date.valueOf(endTime)));
            }
        }
        ret = criteria.list();
        retDataWrapper.setData(ret);*/
        return retDataWrapper;
    }

    @Override
    public PostsEntity getPosts(Long postsId) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(PostsEntity.class);
        criteria.add(Restrictions.eq("postsid", postsId));
        List<PostsEntity> result = criteria.list();
        if (result != null && result.size() > 0) {
            return  result.get(0);
        }
        return null;
    }

	@Override
	public BigInteger getPostCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from  posts";
		List<BigInteger> ret = null;
        Session session = getSession();
        
        try {
            Query query = session.createSQLQuery(sql);
            ret = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ret != null && ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public BigInteger getTodayPostCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from  posts where date(time) = curdate()";
		List<BigInteger> ret = null;
        Session session = getSession();
        
        try {
            Query query = session.createSQLQuery(sql);
            ret = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ret != null && ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public boolean readPost(Long postsId) {
		// TODO Auto-generated method stub
		Session session = getSession();
        String sql = "update posts set read_count = read_count+1 where postsid=?";
        try {
        	Query query = session.createSQLQuery(sql);
        	query.setParameter(0, postsId);
            query.executeUpdate();
        } catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	return false;
		}
        
        return true;
	}

	@Override
	public boolean verify(Long postsid, Long state) {
		// TODO Auto-generated method stub
		Session session = getSession();
        String sql = "update posts set state='" + state + "' where postsid=" + postsid;
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
}
