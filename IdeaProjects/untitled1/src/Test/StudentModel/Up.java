package Test.StudentModel;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Up {

    public   static ComboPooledDataSource dataSource=new ComboPooledDataSource("c3p0-config.xml");


    public  static Connection getCon() throws SQLException, SQLException {

        return   dataSource.getConnection();
    }

}
