package com.banyuan.tool.pool.driudUtil;

import com.banyuan.tool.pool.DBCPUtil;
import com.banyuan.tool.testDBCP.DBCPTool;
import com.banyuan.tool.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDbcp {

    public static void main(String[] args) {


//        PreparedStatement  ps=null;
//        try {
//            ps=DBCPUtil.getConnection().prepareStatement("insert  into  user(uname,password,money)values(?,?,?)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Connection  conn=DBCPUtil.getConnection();
//        if(conn==null){
//            return;
//        }

//        for(int i=0;i<10000;i++){
//            User u=new User();
//            u.setUname("李四"+i);
//            u.setPassword("2123"+i);
//            u.setMoney(i*1.0);
//          //  DBCPTool.writeByOne(u);
//         //   DBCPTool.writeByOne1(u,ps);
//
//        }
        long   start=System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
             DBCPTool.alibaba();
            // DBCPTool.dncp();
        }
        long   end=System.currentTimeMillis();
        System.out.println("一共消耗:"+(end-start)+"毫秒");

        /**
         * 各个连接池的性能对比:
         * HikariCP > Driud > tomcat-jdbc > Dbcp > c3p0     proxool  08
         *
         * springboot
         *
         */


    }

}
