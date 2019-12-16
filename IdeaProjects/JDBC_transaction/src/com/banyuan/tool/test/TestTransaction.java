package com.banyuan.tool.test;

import com.banyuan.tool.service.UserService;
import com.banyuan.tool.service.UserServiceImpl;
import com.banyuan.tool.vo.User;

import java.lang.reflect.Array;
import java.util.*;

public class TestTransaction {

    public static void main(String[] args) {

        UserService us = new UserServiceImpl();

//        us.updateMoney(200.0, "李四", "张三");


//        List<User> list=new ArrayList();
//        list.add(new User("12","2",34.0));
//        list.add(new User("13","3",34.0));
//        list.add(new User("14","4",34.0));
//        list.add(new User("16","6",34.0));
//
//
//        us.addUser(list);

        List<User> list = us.getByName("12");
        for (User u : list) {
            System.out.println(u.toString());
        }


    }

}
