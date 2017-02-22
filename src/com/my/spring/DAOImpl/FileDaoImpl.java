package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.FileDao;
import com.my.spring.model.FileEntity;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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
    public DataWrapper<List<FileEntity>> findByType(Integer type) {
        DataWrapper<List<FileEntity>> retDataWrapper = new DataWrapper<List<FileEntity>>();
        List<FileEntity> ret = new ArrayList<FileEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(FileEntity.class);
        if(type != null) {
            if(type<=6) {
                criteria.add(Restrictions.le("type", 6));
            }else{
                criteria.add(Restrictions.eq("type", type));
            }
        }
        try {
            ret = criteria.list();
        }catch (Exception e){
            System.out.println(e);
        }
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
