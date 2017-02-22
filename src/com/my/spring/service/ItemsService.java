package com.my.spring.service;

import com.my.spring.utils.DataWrapper;
import com.my.spring.model.ItemsEntity;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nixinan on 2017/1/18.
 */
public interface ItemsService {
    DataWrapper<Void> add(ItemsEntity items,String token,MultipartFile exitbasicfile,MultipartFile memberdemandfile,HttpServletRequest request);
    DataWrapper<Void> update(ItemsEntity items);
    DataWrapper<Void> delete(Long itemsid,String token);
    DataWrapper<List<ItemsEntity>> getItemsList(Integer numPerPage,Integer pageNum,String itemtype,String itemname, String teacher, String starttime, String endtime,Long type, Long state);
    DataWrapper<ItemsEntity> getItems(Long itemsid);
    DataWrapper<Void> verify(Long itemsid,Long state,String token);
}
