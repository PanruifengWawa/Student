package com.my.spring.serviceImpl;

import com.my.spring.DAO.ItemsDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.ItemsService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.FileUtils;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public DataWrapper<Void> add(ItemsEntity items,String token,MultipartFile exitbasicfile,MultipartFile memberdemandfile,HttpServletRequest request) {
    	items.setTime(new Timestamp(System.currentTimeMillis()));
    	items.setReleasedate(new Timestamp(System.currentTimeMillis()));
    	items.setExitbasicfilesrc(FileUtils.saveFile(exitbasicfile, request));
    	items.setMemberdemandfilesrc(FileUtils.saveFile(memberdemandfile, request));
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
    public DataWrapper<Void> update(ItemsEntity items) {
        return null;
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
    public DataWrapper<List<ItemsEntity>> getItemsList(Integer numPerPage, Integer pageNum, String itemtype, String itemname, String teacher, String starttime, String endtime, Long type, Long state) {
        return itemsDao.getItemsList(numPerPage, pageNum, itemtype, itemname, teacher, starttime, endtime, type, state);
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

}
