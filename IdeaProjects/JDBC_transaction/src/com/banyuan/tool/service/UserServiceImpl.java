package com.banyuan.tool.service;

import com.banyuan.tool.dao.UseDao;
import com.banyuan.tool.dao.UserDaoImpl;
import com.banyuan.tool.util.DBUtil;
import com.banyuan.tool.vo.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl  implements   UserService {

    UseDao ud=new UserDaoImpl();

    @Override
    public void updateMoney(Double money, String name1, String name2) {

        try {
            DBUtil.conn.setAutoCommit(false); //自动提交关闭

            ud.updateMoney(name1, -money);
            System.out.println(1/0);   //业务层的代码出线了问题  最好回滚
            ud.updateMoney(name2, money);

            DBUtil.conn.commit();//不出任何问题进行提交
        }catch ( Exception  e){
            try {
                DBUtil.conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void addUser(List<User> list) {
            ud.addUser(list);
    }

    @Override
    public List<User> getByName(String name) {
        return ud.getByName(name);
    }
}
