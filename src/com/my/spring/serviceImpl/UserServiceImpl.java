package com.my.spring.serviceImpl;

import com.my.spring.DAO.UserDao;
import com.my.spring.enums.CallStatusEnum;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.UserService;
import com.my.spring.utils.DataWrapper;
import com.my.spring.utils.SessionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.*;

import java.sql.Timestamp;
import java.util.List;
/**
 * Created by Administrator on 2016/6/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public DataWrapper<Void> addUser(UserEntity user) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        if(!userDao.addUser(user)) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(Long userId,String token) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null ||userEntity.getUsertype() != 4) {
        	dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return dataWrapper;
		}
        
        if(!userDao.delete(userId)) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(UserEntity user,String token) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || userEntity.getUserid() != user.getUserid()) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        
        if(user != null && user.getUserid()!=0) {
        	userEntity.setUsername(user.getUsername());
        	userEntity.setUsertype(user.getUsertype());
        	userEntity.setDepartment(user.getDepartment());
        	userEntity.setMajor(user.getMajor());
        	userEntity.setEmail(user.getEmail());
        	userEntity.setTelephone(user.getTelephone());
        	userEntity.setPersonalbrief(user.getPersonalbrief());
//        	userEntity.setPersonaltag(user.getPersonaltag());
            if(userDao.updateUser(userEntity)) {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> changePwd(String password, Long userId,String token) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || userEntity.getUserid() != userId) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        
        
        if(password!=null&&userId!=null)
        {
            if(userDao.changePwd(password,userId))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> changeType(Integer userType, Long userId,String token) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        
        UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity == null || userEntity.getUserid() != userId) {
        	retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        	return retDataWrapper;
		}
        
        if(userType!=null&&userId!=null)
        {
           if(userDao.changeType(userType,userId))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return retDataWrapper;
    }

    /*@Override
    public DataWrapper<List<UserEntity>> getUserList() {
        return userDao.getUserList();
    }*/

    @Override
    public DataWrapper<UserEntity> getUserById(Long userId) {
        DataWrapper<UserEntity> retDataWrapper = new DataWrapper<UserEntity>();

        if(userId != null ) {

            UserEntity userApplicationEntity = userDao.getUserById(userId);
                retDataWrapper.setData(userApplicationEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;

    }



    @Override
    public DataWrapper<Void> login(Long studentid, String password) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity user = userDao.findBystudentid(studentid);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
                SessionManager.removeSessionByUserId(user.getUserid());
				String token = SessionManager.newSession(user);
				retDataWrapper.setToken(token);
            } else {
                retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
            }
        }
        else {
            retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
            return retDataWrapper;


    }

    @Override
    public DataWrapper<Void> register(UserEntity userEntity) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();

            if(userEntity != null && userEntity.getPassword()!= null && userEntity.getUsername()!= null
                    && userEntity.getStudentid()!= null) {
                userEntity.setUsertype(0);
                userEntity.setRegistertime(new Timestamp(System.currentTimeMillis()));
                if(userDao.addUser(userEntity))
                    retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
                else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);

            } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);



        return retDataWrapper;
    }

    @Override
    public DataWrapper<List<UserEntity>> getUserList(Integer numPerPage,Integer pageNum,String userName, Long studentId, String department, String major, Integer userType, String telephone) {

        return userDao.getUserList(numPerPage,pageNum,userName,studentId,department,major,userType,telephone);
    }

	@Override
	public DataWrapper<UserEntity> getUserByToken(String token) {
		// TODO Auto-generated method stub
		DataWrapper<UserEntity> retDataWrapper = new DataWrapper<UserEntity>();

		UserEntity userEntity = SessionManager.getSession(token);
        if (userEntity != null) {
        	UserEntity user = userDao.getUserById(userEntity.getUserid());
        	retDataWrapper.setData(user);
        	return retDataWrapper;
		} else {
			retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
		}
        
        return retDataWrapper;
	}

}
