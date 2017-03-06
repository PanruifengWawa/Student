package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.ItemsDao;
import com.my.spring.utils.DataWrapper;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.my.spring.model.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Repository
public class ItemsDaoImpl  extends BaseDao<ItemsEntity> implements ItemsDao{
    @Override
    public boolean add(ItemsEntity items) {
        return save(items);
    }

    @Override
    public boolean delete(Long itemsId) {
        return delete(get(itemsId));
    }

    @Override
    public boolean verify(Long itemsid, Long state) {
        Session session = getSession();
        String sql = "update items set state='" + state + "' where itemid=" + itemsid;
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
    public DataWrapper<List<ItemsEntity>> getItemsList(Integer numPerPage,Integer pageNum,String itemType,String itemName, String teacher, String starttime, String endtime,Long type, Long state,Long userid,String projectdirection,String labels){
    	DataWrapper<List<ItemsEntity>> retDataWrapper = new DataWrapper<List<ItemsEntity>>();
        List<ItemsEntity> ret = new ArrayList<ItemsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(ItemsEntity.class);
        if (numPerPage == null) {
			numPerPage = 10;
		}
        if (pageNum == null) {
			pageNum = 1;
		}
        
        
        if (itemType != null) {
            criteria.add(Restrictions.like("itemtype", itemType));
        }
        if (itemName != null) {
            criteria.add(Restrictions.like("itemname", itemName));
        }
        if (teacher != null) {
            criteria.add(Restrictions.like("teacher", teacher));
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
        if (type != null) {
            criteria.add(Restrictions.eq("type", type));
        }
        
        if (userid != null) {
        	 criteria.add(Restrictions.eq("userid", userid));
		}
        
        if (projectdirection != null) {
       	 	criteria.add(Restrictions.like("projectdirection", projectdirection));
		}
        if (labels != null) {
        	criteria.add(Restrictions.like("labels",labels,MatchMode.ANYWHERE));
		}
        
        criteria.setProjection(Projections.rowCount());
        int totalltemNum = ((Long) criteria.uniqueResult()).intValue();
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numPerPage);
        criteria.setProjection(null);
        
        if (numPerPage > 0 && pageNum > 0) {
            criteria.setMaxResults(numPerPage);
            criteria.setFirstResult((pageNum - 1) * numPerPage);
        }
        
        retDataWrapper.setCurrentPage(pageNum);
        retDataWrapper.setNumberPerPage(numPerPage);
        retDataWrapper.setTotalPage(totalPageNum);
        retDataWrapper.setTotalNumber(totalltemNum);
        ret = criteria.list();
        retDataWrapper.setData(ret);
        return retDataWrapper;
    }

    @Override
    public ItemsEntity getItems(Long itemsId) {
        return get(itemsId);
    }

	@Override
	public boolean updateItem(ItemsEntity items) {
		// TODO Auto-generated method stub
		return update(items);
	}
}
