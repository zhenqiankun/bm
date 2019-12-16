package dao.daoIMPL;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.Workerdao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.Scanner;

public class Workerc implements Workerdao {
    public Connection connection;
    public Workerc() throws SQLException, ClassNotFoundException {
        QueryRunner queryRunner;
        connection=Connections.getConnection();
    }
    @Override
    public void select() throws SQLException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        PreparedStatement preparedStatement;
        String sql="select * from xiangmu";
        Statement statement=connection.createStatement();
        ResultSet set=statement.executeQuery(sql);
        while (set.next()){
            System.out.println(set.getString("id")+","+set.getString("xiangmuname"));

        }

    }

    @Override
    public void selectAll() throws SQLException {
        String sql="select xiangmu.xiangmuname,worker.vname,worker.workage,worker.jiebiename from xiangmu INNER JOIN worker on xiangmu.id=worker.id";
        Statement statement=connection.createStatement();
        ResultSet set=statement.executeQuery(sql);
        while (set.next()){
            System.out.println(set.getString("xiangmuname")+","+set.getString("vname")+","+set.getString("workage")+","+set.getString("jiebiename"));

        }

    }

    @Override
    public void insert() throws SQLException {
        Scanner  scanner=new Scanner(System.in);
        System.out.println("输入项目名");
        String sql="insert into xiangmu(id,xiangmuname)values(?,?)";
        PreparedStatement p=connection.prepareStatement(sql);
        String name=scanner.next();
        String id=scanner.next();
        p.setString(1,id);
        p.setString(2,name);
        p.execute();
        String sqll="insert into worker (id,workage,age,jiebiename,vname)values(?,?,?,?,?)";
        PreparedStatement p1=connection.prepareStatement(sqll);
        for(int i=0;i<3;i++){
            p1.setString(1,id);
            System.out.println("工作年龄");
            p1.setString(2,scanner.next());
            System.out.println("年龄");
            p1.setString(3,scanner.next());
            System.out.println("级别");
            p1.setString(4,scanner.next());
            System.out.println("名字");
            p1.setString(5,scanner.next());
            p1.execute();
        }

    }

}
