package com.my.spring.DAOImpl;


import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.CommentDao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import com.my.spring.model.CommentEntity;
import com.my.spring.model.CommunicationEntity;
import com.my.spring.utils.DataWrapper;
/**
 * Created by nixinan on 2017/1/17.
 */
@Repository
public class CommentDaoImpl extends BaseDao<CommentEntity> implements CommentDao{
    @Override
    public boolean add(CommentEntity comment) {
        return save(comment);
    }

    @Override
    public boolean delete(Long commentid) {
        return delete(get(commentid));
    }

	@Override
	public BigInteger getCommentCount(Long postsid) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from  comment";
		if (postsid != null) {
			sql += " where postsid=" + postsid;
		}
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
	public CommentEntity getLatestCommentByPostsid(Long postsid) {
		// TODO Auto-generated method stub
		String sql = "select * from comment where postsid=? order by time desc limit 1";
		List<CommentEntity> ret = null;
        Session session = getSession();
        
        try {
            Query query = session.createSQLQuery(sql).addEntity(CommentEntity.class);
            query.setLong(0, postsid);
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
	public DataWrapper<List<CommentEntity>> getByPostId(Integer numPerPage, Integer pageNum,Long postsId) {
		// TODO Auto-generated method stub
		DataWrapper<List<CommentEntity>> dataWrapper = new DataWrapper<List<CommentEntity>>();
		List<CommentEntity> ret = null;
        Session session = getSession();
        String sql = "select c.commentid as commentid,c.postsid as postsid,c.contents as contents,c.time as time,c.userid as userid, u.username as username from comment c,user u where c.userid=u.userid";
        if (postsId != null) {
			sql += " and c.postsid=" + postsId;
		}
        Query query=session.createSQLQuery(sql)
				.addScalar("commentid",StandardBasicTypes.LONG)
				.addScalar("postsid",StandardBasicTypes.LONG)
        		.addScalar("contents",StandardBasicTypes.STRING)
        		.addScalar("time",StandardBasicTypes.TIMESTAMP)
        		.addScalar("userid",StandardBasicTypes.LONG)
        		.addScalar("username",StandardBasicTypes.STRING)
        		.setResultTransformer(Transformers.aliasToBean(CommentEntity.class));
        
        if (numPerPage == null) {
			numPerPage = 10;
		}
        if (pageNum == null) {
			pageNum = 1;
		}
        int totalltemNum = (query.list().size());
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numPerPage);
       
        
        if (numPerPage > 0 && pageNum > 0) {
            query.setMaxResults(numPerPage);
            query.setFirstResult((pageNum - 1) * numPerPage);
        }
        dataWrapper.setCurrentPage(pageNum);
        dataWrapper.setNumberPerPage(numPerPage);
        dataWrapper.setTotalPage(totalPageNum);
        dataWrapper.setTotalNumber(totalltemNum);
        ret=query.list();
        dataWrapper.setData(ret);
        return dataWrapper;
	}


}
