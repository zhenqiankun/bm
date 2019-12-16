package com.banyuan.tool.dao;

import com.banyuan.tool.vo.User;

import java.util.List;

public interface UseDao {


    void   updateMoney(String uname,Double  money);


    void  addUser(List<User> list);


    public  List<User>  getByName(String   name);

}
