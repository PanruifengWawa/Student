package com.my.spring.serviceImpl;

import com.my.spring.DAO.ApplicationDao;
import com.my.spring.DAO.ItemsDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.ItemsService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.FileUtils;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.my.spring.model.ApplicationEntity;
import com.my.spring.model.ItemsEntity;
import com.my.spring.model.UserEntity;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nixinan on 2017/1/18.
 */
@Service("itemsService")
public class ItemsServiceImpl  implements ItemsService{
    @Autowired
    ItemsDao itemsDao;
    
    @Autowired
    ApplicationDao applicationDao;

    @Override
    public DataWrapper<Void> add(ItemsEntity items,String token,MultipartFile exitbasicfile,MultipartFile memberdemandfile,MultipartFile imgfile,HttpServletRequest request) {
    	items.setTime(new Timestamp(System.currentTimeMillis()));
    	items.setReleasedate(new Timestamp(System.currentTimeMillis()));
    	items.setExitbasicfilesrc(FileUtils.saveFile(exitbasicfile, request));
    	items.setMemberdemandfilesrc(FileUtils.saveFile(memberdemandfile, request));
    	items.setImgfilesrc(FileUtils.saveFile(imgfile, request));
    	
    	items.setNowpeople(0);
        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        items.setUserid(userEntity.getUserid());
        items.setState(new Long(0));
        if(items.getItemname() != null && items.getItembrief() != null && itemsDao.add(items))
        {
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> update(Long itemsid,ItemsEntity items,MultipartFile imgfile,HttpServletRequest request,String token) {
    	DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || itemsid == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        ItemsEntity newItems = itemsDao.getItems(itemsid);
        if (newItems == null || newItems.getUserid() != userEntity.getUserid()) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        newItems.setItemname(items.getItemname());
        newItems.setItemleader(items.getItemleader());
        newItems.setTeacher(items.getTeacher());
        newItems.setType(items.getType());
        newItems.setKeywords(items.getKeywords());
        newItems.setItembrief(items.getItembrief());
        newItems.setItemresult(items.getItemresult());
        newItems.setItemcyle(items.getItemcyle());
        newItems.setTelephone(items.getTelephone());
        newItems.setImgfilesrc(FileUtils.saveFile(imgfile, request));
        if (!itemsDao.updateItem(newItems)) {
        	data.setErrorCode(ErrorCodeEnum.Error);
		}
        return data;
    }

    @Override
    public DataWrapper<Void> delete(Long itemsid,String token) {

        DataWrapper<Void> data = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	data.setErrorCode(ErrorCodeEnum.Error);
        	return data;
		}
        
        if(itemsDao.delete(itemsid)){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;

    }

    @Override
    public DataWrapper<List<ItemsEntity>> getItemsList(Integer numPerPage, Integer pageNum, String itemtype, String itemname, String teacher, String starttime, String endtime, Long type, Long state,Long userid,String projectdirection,String labels) {
        return itemsDao.getItemsList(numPerPage, pageNum, itemtype, itemname, teacher, starttime, endtime, type, state ,userid, projectdirection,labels);
    }

    @Override
    public DataWrapper<ItemsEntity> getItems(Long itemsid) {
        DataWrapper<ItemsEntity> retDataWrapper = new DataWrapper<ItemsEntity>();

        if(itemsid != null ) {

            ItemsEntity newsEntity = itemsDao.getItems(itemsid);
            retDataWrapper.setData(newsEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> verify(Long itemsid, Long state,String token) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        
        
        if(itemsid!=null&&state!=null)
        {
            if(itemsDao.verify(itemsid,state))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

	@Override
	public DataWrapper<Void> apply(Long itemsid, String token) {
		// TODO Auto-generated method stub
		DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || itemsid == null) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setItemsid(itemsid);
        applicationEntity.setState(0);
        applicationEntity.setTime(new Timestamp(System.currentTimeMillis()));
        applicationEntity.setUserid(userEntity.getUserid());
        applicationEntity.setUsername(userEntity.getUsername());
        if (!applicationDao.addApplication(applicationEntity)) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
		}
        
		return retDataWrapper;
	}

	@Override
	public DataWrapper<List<ApplicationEntity>> getApplicationList(Long itemsid,Integer state, String token) {
		// TODO Auto-generated method stub
		return applicationDao.getApplicationList(itemsid, state);
	}

	@Override
	public DataWrapper<Void> handleApplication(Long applicationid, Integer state, String token) {
		// TODO Auto-generated method stub
		DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || applicationid == null || state == null) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        if (!applicationDao.handleApplication(applicationid, state)) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
		}
        
        return retDataWrapper;
        
        
	}

}
