package com.banyuan.tool.testDBCP;

import com.banyuan.tool.pool.DBCPUtil;
import com.banyuan.tool.pool.driudUtil.DriudUtil;
import com.banyuan.tool.vo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCPTool {

static Connection   con=null;
static PreparedStatement  ps=null;
    // 不使用连接池  每写一条语句 去创建一个连接
    public static  void   writeByOne(User user){

        String sql="insert  into  user(uname,password,money)values(?,?,?)";
        con=DBCPUtil.getConnection();
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());
            ps.setDouble(3, user.getMoney());

           int  result= ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    //只是用一次开关 写入数据
    public  static   void  writeByOne1(User  user,PreparedStatement  ps){
        try {
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());
            ps.setDouble(3, user.getMoney());

            int  result= ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    //使用ali
    public  static  void  alibaba(){
        String   sql="select *from  user";
        QueryRunner  qr=new QueryRunner(DriudUtil.dataSource);
        try {
            qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //使用dbcp
    public  static   void  dncp(){

        String   sql="select *from  user";
        QueryRunner  qr=new QueryRunner(DBCPUtil.dataSource);
        try {
            qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }










}
