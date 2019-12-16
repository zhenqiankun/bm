package com.banyuan.tool.dao;

import com.banyuan.tool.util.DBUtil;
import com.banyuan.tool.util.DBUtil_Apach;
import com.banyuan.tool.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UseDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet  rs=null;
    @Override
    public void updateMoney(String uname, Double newmoney) {
        String sql = "update  user  set  money=money+? where  uname=?";
        try {
            con = DBUtil.conn;
            ps = con.prepareStatement(sql);
            ps.setDouble(1, newmoney);
            ps.setString(2, uname);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("更新成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    //    @Override
//    public void addUser(List<User> list) {
//
//            String  sql="insert  into  user(uname,password,money) values(?,?,?)";
//            con=DBUtil.conn;
//        try {
//            ps=con.prepareStatement(sql);
//            for (int i = 0; i <list.size(); i++) {
//                ps.setString(1, list.get(i).getUname());
//                ps.setString(2, list.get(i).getPassword());
//                ps.setDouble(3, list.get(i).getMoney());
//                ps.executeUpdate();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    @Override
//    public void addUser(List<User> list) {
//
//        String sql = "insert  into  user(uname,password,money) values(?,?,?)";
//        //阿帕奇公司提供的dbutil连接工具
//        QueryRunner qr=new QueryRunner();
//
//        Object[] []  params=new Object[list.size()][];
//        for (int i = 0; i < list.size(); i++) {
//            params[i]=new Object[]{list.get(i).getUname(),list.get(i).getPassword(),list.get(i).getMoney()};
//        }
//
//        try {
//            qr.batch(DBUtil.conn,sql,params);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//
//        }
//
//    }




    @Override
    public void addUser(List<User> list) {
        String sql = "insert  into  user(uname,password,money) values(?,?,?)";
        //阿帕奇公司提供的dbutil连接工具
        QueryRunner qr=new QueryRunner(DBUtil.getDataSource());
        QueryRunner qr=new QueryRunner
        Object[] []  params=new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            params[i]=new Object[]{list.get(i).getUname(),list.get(i).getPassword(),list.get(i).getMoney()};
        }
        try {
            qr.batch(sql,params);

            /**
             * new QueryRunner(DBUtil.getDataSource());  获取数据源
             *
             *   qr.batch(con,sql,params); 在这里添加连接  有什么区别
             *
             *   前者不需要手动关闭数据连接
             *   后者需要手动关闭数据连接
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //批量删除

    // 根据输入的用户名（不全）  查询出满足条件的
//    public  List<User>  getByName(String   name){
//        List<User>  list=new ArrayList<>();
//        String  sql="select  *from  user where  uname like  ?";
//        try {
//
//            ps=DBUtil.conn.prepareStatement(sql);
//            ps.setString(1, "%"+name+"%");
//            rs=ps.executeQuery();
//            while (rs.next()){
//                User u=new User();
//                u.setUid(rs.getInt("uid"));
//                u.setUname(rs.getString("uname"));
//                u.setPassword(rs.getString("password"));
//                u.setMoney(rs.getDouble("money"));
//                list.add(u);
//
//            }
//            return  list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return  null;
//    }




    public  List<User>  getByName(String   name){
        List<User>  list=new ArrayList<>();
        String  sql="select  *from  user where  uname like  ?";

        try {
            QueryRunner  qr=new QueryRunner(DBUtil.getDataSource());
            //dbutil 连接工具给我们提供了对查询出来的结合操作的处理器   BeanListHandler<>(此结合处理器对具体的那个对象进行处理的class文件)
            list=qr.query(sql, new BeanListHandler<User>(User.class), "%"+name+"%");
            return  list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }





}
