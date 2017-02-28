package com.my.spring.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.my.spring.DAO.ApplicationDao;
import com.my.spring.DAO.BaseDao;
import com.my.spring.model.ApplicationEntity;
import com.my.spring.utils.DataWrapper;

@Repository
public class ApplicationDaoImpl extends BaseDao<ApplicationEntity> implements ApplicationDao {

	@Override
	public boolean addApplication(ApplicationEntity applicationEntity) {
		// TODO Auto-generated method stub
		return save(applicationEntity);
	}

	@Override
	public boolean handleApplication(Long applicationId, Integer state) {
		// TODO Auto-generated method stub
		Session session = getSession();
        String sql = "update application set state='" + state + "' where applicationid=" + applicationId;
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
	public DataWrapper<List<ApplicationEntity>> getApplicationList(Long itemsid,Integer state) {
		// TODO Auto-generated method stub
		DataWrapper<List<ApplicationEntity>> retDataWrapper = new DataWrapper<List<ApplicationEntity>>();
        List<ApplicationEntity> ret = null;
        Session session = getSession();
        Criteria criteria = session.createCriteria(ApplicationEntity.class);
        criteria.add(Restrictions.eq("itemsid", itemsid));
        if (state != null) {
            criteria.add(Restrictions.eq("state", state));
        }
        try {
			ret = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        retDataWrapper.setData(ret);
        return retDataWrapper;
	}

}
