package com.my.spring.service;

import com.my.spring.utils.DataWrapper;
import com.my.spring.model.*;
import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface UserService {
    DataWrapper<Void> addUser(UserEntity user);
    DataWrapper<Void> delete(Long userId,String token);
    DataWrapper<Void> update(UserEntity user,String token);
    DataWrapper<Void> changePwd(String password,Long userId,String token);
    DataWrapper<Void> changeType(Integer userType, Long userId,String token);
  /*  DataWrapper<List<UserEntity>> getUserList();*/
    DataWrapper<UserEntity> getUserById(Long userId);
    DataWrapper<UserEntity> getUserByToken(String token);
    //DataWrapper<Void> verify(Long sutdentid,String password);
    DataWrapper<Void> login(Long studentid,String password);
    DataWrapper<Void> register(UserEntity userEntity);
    DataWrapper<List<UserEntity>> getUserList(Integer numPerPage,Integer pageNum,String userName,Long studentId,String department,String major,Integer userType,String telephone);
    
    DataWrapper<Void> adminlogin(Long studentid,String password);
    DataWrapper<Void> setAdmin(Long userId,Integer type,String token);
}
