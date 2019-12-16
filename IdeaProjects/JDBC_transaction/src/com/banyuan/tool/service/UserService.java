package com.banyuan.tool.service;

import com.banyuan.tool.vo.User;

import java.util.List;

public interface UserService {

    void  updateMoney(Double money,String name1,String name2);

    void  addUser(List<User> list);

    public  List<User>  getByName(String   name);

}
