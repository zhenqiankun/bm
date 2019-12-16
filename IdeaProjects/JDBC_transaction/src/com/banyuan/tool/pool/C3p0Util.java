package com.banyuan.tool.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Util {


    /**
     * 如何设置连接池
     */

    private  static ComboPooledDataSource dataSource=new ComboPooledDataSource("c3p0-config.xml");


    public  static Connection getCon() throws SQLException {

        return   dataSource.getConnection();
    }



}
