package com.my.spring.DAO;

import com.my.spring.utils.DataWrapper;
import com.my.spring.model.*;
import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface UserDao {
    boolean addUser(UserEntity user);
    //DataWrapper<List<UserEntity>> verify(Long studentid,String password);
    //DataWrapper<List<UserEntity>> findUser(Long studentid);
    boolean delete(Long userId);
    boolean updateUser(UserEntity user);
    boolean changePwd(String password,Long userId);
    boolean changeType(Integer userType,Long userId);
    List<UserEntity> getUserList();
    UserEntity findBystudentid(Long studentid);
    UserEntity getUserById(Long id);
    DataWrapper<List<UserEntity>> getUserList(Integer numPerPage,Integer pageNum, String userName,Long studentId,String department,String major,Integer userType,String telephone);
}
