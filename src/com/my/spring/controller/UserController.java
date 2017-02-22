package com.my.spring.controller;

import com.my.spring.model.UserEntity;
import com.my.spring.service.UserService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * Created by Administrator on 2016/6/22.
 */
@Controller
@RequestMapping(value="api/user")
public class UserController {
    @Autowired
    UserService userService;

 /*   @RequestMapping(value="addUser", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> addUser(
            @ModelAttribute UserEntity user,
            @RequestParam(value = "token",required = false) String token){
        //System.out.println("sasdhaskjfhdkjsah");
        return userService.addUser(user);
    }*/


    /*@RequestMapping(value="getUserList")
    @ResponseBody
    public DataWrapper<List<UserEntity>> getUserList(
            @RequestParam(value = "token",required = false) String token){


       // return userService.getUserList();
        return  userService.getUserList();
    }*/

    
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> verifyUser(@RequestParam(value = "studentid",required = true) Long studentid,
                        @RequestParam(value = "password",required = true) String password){

        return userService.login(studentid,password);
    }

    @RequestMapping(value="register")
    @ResponseBody
    public DataWrapper<Void> register(
            @ModelAttribute UserEntity userEntity)
    {
    	userEntity.setUserid(null);

        return userService.register(userEntity);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "userid",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){
       // userId= Long.valueOf(2);
        return userService.delete(userId,token);
    }

    @RequestMapping(value="update",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute UserEntity user,
            @RequestParam(value = "token",required = false) String token){

        return userService.update(user,token);
    }
    @RequestMapping(value="getbyid")
    @ResponseBody
    public DataWrapper<UserEntity> getbyid(
            @RequestParam(value = "userid",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){

        return userService.getUserById(userId);
    }
    
    @RequestMapping(value="getbytoken")
    @ResponseBody
    public DataWrapper<UserEntity> getbytoken(
            @RequestParam(value = "token",required = false) String token){

        return userService.getUserByToken(token);
    }

    @RequestMapping(value="changePwd")
    @ResponseBody
    public DataWrapper<Void> changePwd(
            @RequestParam(value = "password",required = false) String password,
            @RequestParam(value = "userid",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){

        return userService.changePwd(password,userId,token);
    }
    @RequestMapping(value="changeType")
    @ResponseBody
    public DataWrapper<Void> changeType(
            @RequestParam(value = "usertype",required = false) Integer userType,
            @RequestParam(value = "userid",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){
        return userService.changeType(userType,userId,token);
    }

    @RequestMapping(value="getUserList",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<UserEntity>> getUserList(
            @RequestParam(value = "numperpage",required = false) Integer numPerPage,
            @RequestParam(value = "pagenum",required = false) Integer pageNum,
            @RequestParam(value = "username",required = false) String userName,
            @RequestParam(value = "studentid",required = false) Long studentId,
            @RequestParam(value = "department",required = false) String department,
            @RequestParam(value = "major",required = false) String major,
            @RequestParam(value = "usertype",required = false) Integer userType,
            @RequestParam(value = "telephone",required = false) String telephone,
            @RequestParam(value = "token",required = false) String token){

        return userService.getUserList(numPerPage,pageNum,userName,studentId,department,major,userType,telephone);
    }
}
