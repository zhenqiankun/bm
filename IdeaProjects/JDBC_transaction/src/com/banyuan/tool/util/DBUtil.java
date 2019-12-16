package com.banyuan.tool.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    static String url = null;
  private  static  ComboPooledDataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");

  public static  Connection  conn=null;

  static{
      try {
          conn=dataSource.getConnection();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }


  public   static ComboPooledDataSource  getDataSource(){

      return  dataSource;
  }



}
