package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.FileDao;
import com.my.spring.model.FileEntity;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/2/14.
 */
@Repository
public class FileDaoImpl extends BaseDao<FileEntity> implements FileDao {
    @Override
    public boolean addFile(FileEntity file) {
        return save(file);
    }

    @Override
    public boolean deleteFile(Long fileId) {
    	return delete(get(fileId));

    }

    @Override
    public boolean updateFile(FileEntity file) {
        return update(file);
    }

    @Override
    public DataWrapper<List<FileEntity>> findByType(Integer type,Integer numPerPage,Integer pageNum) {
        DataWrapper<List<FileEntity>> retDataWrapper = new DataWrapper<List<FileEntity>>();
        
        if (numPerPage == null) {
			numPerPage = 10;
		}
        if (pageNum == null) {
			pageNum = 1;
		}
        
        List<FileEntity> ret = new ArrayList<FileEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(FileEntity.class);
        if(type != null) {
        	criteria.add(Restrictions.eq("type", type));
        }
        
        criteria.setProjection(Projections.rowCount());
        int totalltemNum = ((Long) criteria.uniqueResult()).intValue();
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numPerPage);
        criteria.setProjection(null);
        
        if (numPerPage > 0 && pageNum > 0) {
            criteria.setMaxResults(numPerPage);
            criteria.setFirstResult((pageNum - 1) * numPerPage);
        }
        
        try {
            ret = criteria.list();
        }catch (Exception e){
            System.out.println(e);
        }
        retDataWrapper.setCurrentPage(pageNum);
        retDataWrapper.setNumberPerPage(numPerPage);
        retDataWrapper.setTotalPage(totalPageNum);
        retDataWrapper.setTotalNumber(totalltemNum);
        retDataWrapper.setData(ret);
        return retDataWrapper;
    }

    @Override
    public FileEntity getFileById(Long id) {
        return get(id);
    }

    @Override
    public List<FileEntity> getFileByIds(String ids) {
        List<FileEntity> list = null;
        String sql = "select {f.*} "
                + "from t_file f "
                + "where f.id in " + ids;
        Session session = getSession();
        Query query = session.createSQLQuery(sql)
                .addEntity("c",FileEntity.class);
        try {
            list = query.list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
