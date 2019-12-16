package com.banyuan.tool.pool;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtil {

    static   FileInputStream  fis=null;
    public static DataSource dataSource=null;

    static{
        try {
           fis= new FileInputStream("src/db.properties");
            Properties p=new Properties();
            p.load(fis);
            dataSource=BasicDataSourceFactory.createDataSource(p);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public   static Connection getConnection(){
        try {
            return   dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }


    /**
     * HikariCP   光连接池
     */

}
