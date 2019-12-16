package com.banyuan.tool.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil_Apach {
    static  Connection con=null;
    public  static Connection  getConnection(){
        String  url="jdbc:mysql://localhost:3306/jian";
        String  driver="com.mysql.jdbc.Driver";
        String  username="root";
        String  password="zhou";

        try {
            Class.forName(driver);
            try {
                con= DriverManager.getConnection(url, username,password);
                return con;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public   static  void  closeCon(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
