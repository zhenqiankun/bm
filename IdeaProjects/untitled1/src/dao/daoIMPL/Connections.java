package dao.daoIMPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections  {
    public static  Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/main";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, "root", "");
        return connection;
    }
}
