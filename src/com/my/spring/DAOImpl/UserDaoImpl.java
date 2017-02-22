package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.UserDao;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.my.spring.model.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/6/22.
 */
@Repository
public class UserDaoImpl extends BaseDao<UserEntity> implements UserDao {

    @Override
    public boolean addUser(UserEntity user) {

        return save(user);
    }

    /*@Override
    public DataWrapper<List<UserEntity>> verify(Long studentid,String password) {

        DataWrapper<List<UserEntity>> retDataWrapper = new DataWrapper<List<UserEntity>>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
        List<UserEntity> list =criteria.add(Restrictions.eq("StudentId",studentid)).add(Restrictions.eq("Password",password)).list();
        retDataWrapper.setData(list);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<List<UserEntity>> findUser(Long studentid) {

       *//* return super.find("from user where UserName=");*//*
        DataWrapper<List<UserEntity>> retDataWrapper=new DataWrapper<List<UserEntity>>();
        Session session=getSession();
        Criteria criteria=session.createCriteria(UserEntity.class);
        List<UserEntity> list=criteria.add(Restrictions.eq("StudentId",studentid)).list();
        retDataWrapper.setData(list);
        return retDataWrapper;
    }*/

    /*@Override
    public List<UserEntity> findUser(UserEntity user) {
        Session session=getSession();
        Criteria criteria=session.createCriteria(UserEntity.class);
        List<UserEntity> list = criteria.add(Restrictions.eq("userName",user.getUserName()))
                .add(Restrictions.eq("password",user.getPassword()))
                .list();
        return list;
    }*/


    @Override
    public boolean delete(Long userId) {
        return delete(get(userId));
    }

    @Override
    public boolean updateUser(UserEntity user) {
        return update(user);
    }

    @Override
    public boolean changePwd(String password,Long userId) {
        Session session = getSession();

       String sql="update user set Password='"+password+"' where UserId="+userId;
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
    public boolean changeType(Integer userType, Long userId) {
        Session session = getSession();
        String sql="update user set UserType='"+userType+"' where UserId="+userId;
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
        return false;
    }

    @Override
    public List<UserEntity> getUserList() {

        List<UserEntity> ret = new ArrayList<UserEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(UserEntity.class);

        ret= criteria.list();
        return ret;
    }


    @Override
    public UserEntity findBystudentid(Long studentid) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("studentid", studentid));
        List<UserEntity> result = criteria.list();
        if (result != null && result.size() > 0) {
            return (UserEntity) result.get(0);
        }
        return null;
    }

    @Override
    public UserEntity getUserById(Long userId) {

        return get(userId);
    }

    @Override
    public DataWrapper<List<UserEntity>> getUserList(Integer numPerPage,Integer pageNum,String userName, Long studentId, String department, String major, Integer userType, String telephone) {
        DataWrapper<List<UserEntity>> retDataWrapper = new DataWrapper<List<UserEntity>>();
        List<UserEntity> ret = new ArrayList<UserEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
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
            if (userName != null) {
                criteria.add(Restrictions.like("username", userName));
            }
            if (studentId != null) {
                criteria.add(Restrictions.eq("studentid", studentId));
            }
            if (department != null) {
                criteria.add(Restrictions.like("department", department));
            }
            if (major != null) {
                criteria.add(Restrictions.like("major", major));
            }
            if (userType != null) {
                criteria.add(Restrictions.like("usertype", userType));
            }
            if (telephone != null) {
                criteria.add(Restrictions.like("telephone", telephone));
            }
            retDataWrapper.setCurrentPage(pageNum);
            retDataWrapper.setNumberPerPage(numPerPage);
            retDataWrapper.setTotalPage(totalPageNum);
            retDataWrapper.setTotalNumber(totalltemNum);
            ret = criteria.list();
            retDataWrapper.setData(ret);
            return retDataWrapper;
        }


}
