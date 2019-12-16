package com.banyuan.tool.pool.driudUtil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DriudUtil {

    static FileInputStream  fis=null;

    public   static DataSource  dataSource;

    static{

        try {

           fis= new FileInputStream("src/driud.properties");
            Properties  p=new Properties();
            p.load(fis);
            dataSource=DruidDataSourceFactory.createDataSource(p);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static Connection  getConnection(){
        try {
            return   dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }









}
