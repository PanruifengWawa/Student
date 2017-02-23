package com.my.spring.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.CommentReplyDao;
import com.my.spring.model.CommentReplyEntity;

@Repository
public class CommentReplyDaoImpl extends BaseDao<CommentReplyEntity> implements CommentReplyDao {

	@Override
	public boolean addCommentReply(CommentReplyEntity commentReplyEntity) {
		// TODO Auto-generated method stub
		return save(commentReplyEntity);
	}

	@Override
	public boolean deleteCommentReply(Long commentReplyId) {
		// TODO Auto-generated method stub
		return delete(get(commentReplyId));
	}

	@Override
	public List<CommentReplyEntity> getByCommentId(Long commentId) {
		// TODO Auto-generated method stub
		List<CommentReplyEntity> ret = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(CommentReplyEntity.class);
        criteria.add(Restrictions.eq("commentid",commentId));
        criteria.addOrder(Order.asc("time"));
        try {
            ret = criteria.list();
        }catch (Exception e){
            e.printStackTrace();
        }

		return ret;
	}

}
