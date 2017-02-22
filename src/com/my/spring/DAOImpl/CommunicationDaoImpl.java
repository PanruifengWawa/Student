package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.CommunicationDao;
import com.my.spring.model.CommunicationEntity;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Repository
public class CommunicationDaoImpl extends BaseDao<CommunicationEntity>implements CommunicationDao{

	@Override
	public DataWrapper<List<CommunicationEntity>> getCommunicationList(Integer numPerPage, Integer pageNum,
			String theme, String title) {
		// TODO Auto-generated method stub
		DataWrapper<List<CommunicationEntity>> dataWrapper=new DataWrapper<List<CommunicationEntity>>();
		List<CommunicationEntity> ret = null;
		String sql = "select p.postsid as postsId,p.theme as theme,p.title as title, u.username as userName,p.time as publishedTime, p.read_count as readCount from posts p, user u where p.userid = u.userid";
		if (theme != null) {
			sql += " and p.theme LIKE '%"+theme+"%'";
		}
		if (title != null) {
			sql += " and p.title LIKE '%"+title+"%'";
		}
		sql += " ORDER BY publishedTime DESC";
		Session session = getSession();
		Query query=session.createSQLQuery(sql)
				.addScalar("postsId",StandardBasicTypes.LONG)
        		.addScalar("theme",StandardBasicTypes.STRING)
        		.addScalar("title",StandardBasicTypes.STRING)
        		.addScalar("userName",StandardBasicTypes.STRING)
        		.addScalar("readCount",StandardBasicTypes.BIG_INTEGER)
        		.addScalar("publishedTime",StandardBasicTypes.TIMESTAMP)
        		.setResultTransformer(Transformers.aliasToBean(CommunicationEntity.class));
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

//    @Override
//    public DataWrapper<List<CommunicationEntity>> getCommunicationList(Integer numPerPage, Integer pageNum, String theme, String title, String userName, Long replyQuantity, String contents) {
//        DataWrapper<List<CommunicationEntity>> dataWrapper=new DataWrapper<List<CommunicationEntity>>();
//        List<CommunicationEntity> ret = new ArrayList<CommunicationEntity>();
//        Session session = getSession();
//        Transaction trans = session.beginTransaction();
//        StringBuffer stringBuffer=new StringBuffer("select p.theme as theme,p.title as title,u.username as userName,COUNT(*) as replyQuantity,p.time as publishedTime,c.contents as contents,c.time as replyTime FROM `comment` c inner JOIN posts p on c.postsid=p.postsid INNER JOIN `user` u on c.userid=u.userid ");
//        stringBuffer.append(" where 1=1 ");
//        if(theme!=null)
//        {
//            stringBuffer.append(" and p.theme LIKE '%"+theme+"%'");
//        }
//        if(title!=null)
//        {
//            stringBuffer.append(" and p.title LIKE '%"+title+"%'");
//        }
//        if(userName!=null)
//        {
//            stringBuffer.append(" and u.username LIKE '%"+userName+"%'  ");
//        }
//        if(replyQuantity!=null)
//        {
//            stringBuffer.append(" and replyquantity="+replyQuantity+" ");
//        }
//        if(contents!=null)
//        {
//            stringBuffer.append(" and c.contents LIKE '%"+contents+"%'  ");
//        }
//        stringBuffer.append(" GROUP BY p.postsid ");
//        stringBuffer.append(" ORDER BY publishedTime DESC ");
//        Query query=session.createSQLQuery(stringBuffer.toString())
//        		.addScalar("theme",StandardBasicTypes.STRING)
//        		.addScalar("title",StandardBasicTypes.STRING)
//        		.addScalar("userName",StandardBasicTypes.STRING)
//        		.addScalar("replyQuantity",StandardBasicTypes.LONG)
//        		.addScalar("contents",StandardBasicTypes.STRING)
//        		.addScalar("publishedTime",StandardBasicTypes.TIMESTAMP)
//        		.addScalar("replyTime",StandardBasicTypes.TIMESTAMP)
//        		.setResultTransformer(Transformers.aliasToBean(CommunicationEntity.class));
//        if (numPerPage == null) {
//			numPerPage = 10;
//		}
//        if (pageNum == null) {
//			pageNum = 1;
//		}
//        int totalltemNum = (query.list().size());
//        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numPerPage);
//       
//        
//        if (numPerPage > 0 && pageNum > 0) {
//            query.setMaxResults(numPerPage);
//            query.setFirstResult((pageNum - 1) * numPerPage);
//        }
//        trans.commit();
//        dataWrapper.setCurrentPage(pageNum);
//        dataWrapper.setNumberPerPage(numPerPage);
//        dataWrapper.setTotalPage(totalPageNum);
//        dataWrapper.setTotalNumber(totalltemNum);
//        ret=query.list();
//        dataWrapper.setData(ret);
//        return dataWrapper;
//    }
}
