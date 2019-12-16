package Test;

import Test.StudentModel.Up;
import org.apache.commons.dbutils.QueryRunner;
import pl.Re;

import javax.sql.DataSource;
import java.io.OutputStream;
import java.sql.*;
import java.util.List;

public class Conntions {
    public Connection connection;
  public Conntions() throws SQLException, ClassNotFoundException {

        this.connection= Up.getCon();
    }
    public boolean  select(String lei,String name,String password) throws SQLException {
      String sql=null;
      if(lei.equals("学生")){
          sql="select * from student where stringname=? and password=?";
      }
      else{
          sql="select * from teacher where stringname=? and password=?";
      }
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
      ResultSet resultSet =preparedStatement.executeQuery();
        if(resultSet.next()){
            preparedStatement.close();
            return true;
        }
        preparedStatement.close();
        return  false;
    }
    public ResultSet example() throws SQLException {
      String sqll="select count(*) from examine";
      PreparedStatement preparedStatementt=connection.prepareStatement(sqll);
      ResultSet set=preparedStatementt.executeQuery();
      int x=0;
      while (set.next()) {
        x = set.getInt(1);
      }
      System.out.println(x);

      int y=(int)(Math.random()*(x-19));
      System.out.println(y);
      String sql="select * from examine limit  20 offset ?";
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setInt(1,y);
      ResultSet sett=preparedStatement.executeQuery();
      return sett;
    }
    public void studentresult(int p) throws SQLException {
      String sql="update  student  set result= ? where stringname=? ";
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,String.valueOf(p));
      preparedStatement.setString(2, ServerThread.name);
      preparedStatement.executeUpdate();
    }
    public int chenji(String name) throws SQLException {
        System.out.println(name);
      String sql="select result from student where stringname=?";
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,name);

      ResultSet resultSet=preparedStatement.executeQuery();
      int u=0;
      while (resultSet.next()){
          u=resultSet.getInt(1);
      }
      return u;
    }
    public  void update( String password) throws SQLException {
      String sql="update student set password=? where stringname=?";
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,password);
      preparedStatement.setString(2,ServerThread.name);
      preparedStatement.executeUpdate();
    }
    public void insertimu(String pl) throws SQLException {
      String sql="insert into examine(f2,f3,f4,f5,f6,f7)values(?,?,?,?,?,?)";
        String [] tem=pl.split("#");
      System.out.println(pl);
        QueryRunner queryRunner = new QueryRunner(Up.dataSource);
        Object[][] params = new Object[tem.length][];
        for(int j=0;j<tem.length;j++) {
            String[] nb = tem[j].split("@");
            params[j]=new Object[]{nb[0],nb[1],nb[2],nb[3],nb[4],nb[5]};
        }
        queryRunner.batch(sql,params);
    }
    public void addstudent(String pl) throws SQLException {
    String sql="insert into student(stringname,name)values(?,?)";
    String []temp=pl.split("#");
    QueryRunner queryRunner=new QueryRunner(Up.dataSource);
    Object[][] params=new Object[temp.length][];
    for(int j=0;j<temp.length;j++){
      String [] nb=temp[j].split("@");
      params[j]=new Object[]{nb[0],nb[1]};
    }
    queryRunner.batch(sql,params);
    }
    public String  selstudent(String name) throws SQLException {

    String sql="select * from student where stringname=?";
    PreparedStatement preparedStatement=connection.prepareStatement(sql);
    preparedStatement.setString(1,name);
    ResultSet set=preparedStatement.executeQuery();
    String pl="";
    while (set.next()){
      pl+=set.getString("name")+","+set.getString("result");
    }
    return pl;
    }
    public void delstudent(String name) throws SQLException {
    String sql="delete from student where stringname=?";
      System.out.println(name);
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.executeUpdate();
    }
    public void upstudent(String Stringname,String name,String resutl) throws SQLException {
    String sql="update student set name=? ,result=? where stringname=?";
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,name);
      preparedStatement.setString(2,resutl);
      preparedStatement.setString(3,Stringname);
      preparedStatement.executeUpdate();

    }
    public ResultSet delex(String number) throws SQLException {
    String sql="select * from examine limit 5 offset ?";
    PreparedStatement p=connection.prepareStatement(sql);

   p.setInt(1,Integer.parseInt(number)*5);
    ResultSet set=p.executeQuery();
    return  set;
    }
  public void delexpl(List<String> list) throws SQLException {
    String sql="delete from examine where f1 =?";
    PreparedStatement p=connection.prepareStatement(sql);
    for(int i=0;i<list.size();i++){
      p.setInt(1,Integer.parseInt(list.get(i)));
      p.addBatch();
    }
    p.executeBatch();


  }
    public int selectt() throws SQLException {

    String sql="select count(*) from examine";
    int x=0;
      PreparedStatement p=connection.prepareStatement(sql);
      ResultSet  set=p.executeQuery();
      while (set.next()){
        x=Integer.parseInt(set.getString(1));
      }
      return x;
    }
    public ResultSet selexamine(String like) throws SQLException {
      String sql="select * from examine where f2 like ?";
      PreparedStatement p=connection.prepareStatement(sql);
      String likee="%"+like+"%";
      p.setString(1,likee);
      ResultSet  set=p.executeQuery();
    return set;
    }
    public void upex(List<List<String>>ll) throws SQLException {
      String sql="update examine  set f2=?,f3=?,f4=?,f5=?,f6=?,f7=? where f1 =? ";
      PreparedStatement p=connection.prepareStatement(sql);
      for(List<String> list:ll) {
        System.out.println(list.get(6));
        for (int i = 0; i < list.size(); i++) {
          p.setString(1,list.get(1));
          p.setString(2,list.get(2));
          p.setString(3,list.get(3));
          p.setString(4,list.get(4));
          p.setString(5,list.get(5));
          p.setString(6,list.get(6));
          p.setInt(7,Integer.parseInt(list.get(0)));
          p.addBatch();
        }
      }
      p.executeBatch();
    }
}
