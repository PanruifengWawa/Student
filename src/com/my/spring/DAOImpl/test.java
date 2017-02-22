package com.my.spring.DAOImpl;

import java.util.List;

/**
 * Created by nixinan on 2017/1/10.
 */
public class test {
    public static void main(String[] args)
    {
        UserDaoImpl user=new UserDaoImpl();
        List list=(List)user.getUserList();
        System.out.print(list);

    }
}
