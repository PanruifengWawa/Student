package com.my.spring.utils;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.my.spring.model.UserEntity;

/**
 * Created by tian on 16/9/27.
 */
public class SessionManager {
    private static int KEY_COUNT = 0;
    private static HashMap<String, UserEntity> USER_SESSION_MAP = new HashMap<String, UserEntity>();

    public static String newSession(UserEntity user) {

        String sessionKey = UUIDGenerator.getCode("SK");

        ++KEY_COUNT;
        if (KEY_COUNT >= 10000000) {
            KEY_COUNT = 0;
        }

        USER_SESSION_MAP.put(sessionKey, user);
//        log.info(
//                "Session Updated! Key:" + sessionKey +
//                        " UserId:" + user.getId() +
//                        " UserName:" + user.getName());
//        System.out.println(USER_SESSION_MAP);
        return sessionKey;
    }

    public static UserEntity getSession(String key) {
        return USER_SESSION_MAP.get(key);
    }
    public static String getSessionByUserID(Long userId){
        Set<String> set = USER_SESSION_MAP.keySet();
        for(String key :set){
            if(USER_SESSION_MAP.get(key).getUserid()==userId)
                return key;
        }
        return null;
    }
    public static void removeSession(String key) {
        if (USER_SESSION_MAP.containsKey(key)) {
            //log.info("Session Destroyed! Key:" + key);
            USER_SESSION_MAP.remove(key);
        }
    }

    /**
     * 删除某用户的Session
     * @param userId
     */
    public static void removeSessionByUserId(Long userId) {
        Iterator<Map.Entry<String, UserEntity>> iter = USER_SESSION_MAP.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, UserEntity> entry =  iter.next();
            String key = entry.getKey();
            UserEntity value = entry.getValue();
            if (value!=null && value.getUserid() == userId) {
                removeSession(key);
                break;
            }

        }


    }
}