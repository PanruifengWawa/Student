package com.my.spring.controller;

import com.my.spring.service.NewsService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.my.spring.model.NewsEntity;
import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
@Controller
@RequestMapping(value="api/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping(value="add",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute NewsEntity newsEntity,
            @RequestParam(value = "token",required = false) String token)
    {

        return newsService.addNews(newsEntity,token);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "newsid",required = false) Long newsid,
            @RequestParam(value = "token",required = false) String token){

        return newsService.deleteNews(newsid,token);
    }

    @RequestMapping(value="verify")
    @ResponseBody
    public DataWrapper<Void> verify(
            @RequestParam(value = "state",required = false) Long state,
            @RequestParam(value = "newsid",required = false) Long newsid,
            @RequestParam(value = "token",required = false) String token){

        return newsService.verify(newsid,state,token);
    }

    @RequestMapping(value="getbyid")
    @ResponseBody
    public DataWrapper<NewsEntity> getbyid(
            @RequestParam(value = "newsid",required = false) Long newsid,
            @RequestParam(value = "token",required = false) String token){

        return newsService.getNewsById(newsid);
    }

    @RequestMapping(value="getNewsList",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<NewsEntity>> getNewsList(
            @RequestParam(value = "numperpage",required = false) Integer numPerPage,
            @RequestParam(value = "pagenum",required = false) Integer pageNum,
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "starttime",required = false) String starttime,
            @RequestParam(value = "endtime",required = false) String endtime,
            @RequestParam(value = "state",required = false) Long state,
            @RequestParam(value = "token",required = false) String token){

        return newsService.getNewsList(numPerPage,pageNum,title,starttime,endtime,state);
    }
}
