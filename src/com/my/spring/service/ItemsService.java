package com.my.spring.service;

import com.my.spring.utils.DataWrapper;
import com.my.spring.model.ApplicationEntity;
import com.my.spring.model.ItemsEntity;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nixinan on 2017/1/18.
 */
public interface ItemsService {
    DataWrapper<Void> add(ItemsEntity items,String token,MultipartFile exitbasicfile,MultipartFile memberdemandfile,MultipartFile imgfile,HttpServletRequest request);
    DataWrapper<Void> update(Long itemsid,ItemsEntity items,MultipartFile imgfile,HttpServletRequest request,String token);
    DataWrapper<Void> delete(Long itemsid,String token);
    DataWrapper<List<ItemsEntity>> getItemsList(Integer numPerPage,Integer pageNum,String itemtype,String itemname, String teacher, String starttime, String endtime,Long type, Long state,Long userid,String projectdirection,String lables);
    DataWrapper<ItemsEntity> getItems(Long itemsid);
    DataWrapper<Void> verify(Long itemsid,Long state,String token);
    
    DataWrapper<Void> apply(Long itemsid,String token);
    DataWrapper<List<ApplicationEntity>> getApplicationList(Long itemsid,Integer state,String token);
    DataWrapper<Void> handleApplication(Long applicationid,Integer state,String token);
}
