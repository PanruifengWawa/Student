package com.my.spring.controller;

import com.my.spring.service.ItemsService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.my.spring.model.ApplicationEntity;
import com.my.spring.model.ItemsEntity;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nixinan on 2017/1/18.
 */
@Controller
@RequestMapping(value = "api/items")
public class ItemsController  {
    @Autowired
    ItemsService itemsService;
    @RequestMapping(value="add",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute ItemsEntity items,
            @RequestParam(value = "start",required = false) String starttime,
            @RequestParam(value = "end",required = false) String endtime,
            @RequestParam(value = "exitbasicfile", required = false) MultipartFile exitbasicfile,
            @RequestParam(value = "memberdemandfile", required = false) MultipartFile memberdemandfile,
            HttpServletRequest request,
            @RequestParam(value = "token",required = false) String token)
    {
    	items.setStarttime(DateUtil.parse(starttime));
    	items.setEndtime(DateUtil.parse(endtime));
        return itemsService.add(items, token, exitbasicfile, memberdemandfile,request);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "itemsid",required = false) Long itemsid,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.delete(itemsid,token);
    }

    @RequestMapping(value="verify")
    @ResponseBody
    public DataWrapper<Void> verify(
            @RequestParam(value = "state",required = false) Long state,
            @RequestParam(value = "itemsid",required = false) Long itemsid,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.verify(itemsid,state,token);
    }

    @RequestMapping(value="getbyid")
    @ResponseBody
    public DataWrapper<ItemsEntity> getbyid(
            @RequestParam(value = "itemsid",required = false) Long itemsid,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.getItems(itemsid);
    }

    @RequestMapping(value="getItemsList",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<ItemsEntity>> getNewsList(
            @RequestParam(value = "numperpage",required = false) Integer numPerPage,
            @RequestParam(value = "pagenum",required = false) Integer pageNum,
            @RequestParam(value = "itemtype",required = false) String itemtype,
            @RequestParam(value = "itemname",required = false) String itemname,
            @RequestParam(value = "teacher",required = false) String teacher,
            @RequestParam(value = "starttime",required = false) String starttime,
            @RequestParam(value = "endtime",required = false) String endtime,
            @RequestParam(value = "type",required = false) Long type,
            @RequestParam(value = "state",required = false) Long state,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.getItemsList(numPerPage, pageNum, itemtype,itemname,teacher,starttime,endtime,type,state);
    }
    
    @RequestMapping(value="apply",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> apply(
            @RequestParam(value = "itemsid",required = true) Long itemsid,
            @RequestParam(value = "token",required = false) String token) {

        return itemsService.apply(itemsid, token);
    }
    
    @RequestMapping(value="getApplicationList",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<List<ApplicationEntity>> getApplicationList(
            @RequestParam(value = "itemsid",required = true) Long itemsid,
            @RequestParam(value = "state",required = false) Integer state,
            @RequestParam(value = "token",required = false) String token) {

        return itemsService.getApplicationList(itemsid, state,token);
    }
    
    @RequestMapping(value="handleApplication",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> handleApplication(
            @RequestParam(value = "applicationid",required = true) Long applicationid,
            @RequestParam(value = "state",required = true) Integer state,
            @RequestParam(value = "token",required = false) String token) {

        return itemsService.handleApplication(applicationid, state, token);
    }

}
