package com.banyuan.tool.pool.driudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDriud {


    public static void main(String[] args) throws SQLException {
       Connection  con= DriudUtil.getConnection();
        String  sql="select *from  user";
        PreparedStatement  ps=null;

        ps=  con.prepareStatement(sql);

        ResultSet  rs=ps.executeQuery();
        if(rs.next()){
            System.out.println("有结果");
        }


    }

}
