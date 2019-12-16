package com.banyuan.tool.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestC3p0 {
    static Connection con=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    public static void main(String[] args) throws SQLException {

        Connection  con=C3p0Util.getCon();

        String  sql="select *from  user";
        ps= con.prepareStatement(sql);

        rs= ps.executeQuery();

        rs.close();
        ps.clearParameters();
        con.close();


    }


}
