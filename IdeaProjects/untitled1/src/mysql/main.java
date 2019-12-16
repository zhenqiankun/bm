package mysql;

import java.sql.*;
public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/myemployees";
        Class.forName("com.mysql.jdbc.Driver");
        String sql="select * from locations";
        Connection connection= DriverManager.getConnection(url,"root","");
        Statement statement=connection.createStatement();
        ResultSet re=statement.executeQuery(sql);
        while (re.next()){
            System.out.println(re.getString("city"));
        }
    }
}
