package dao.daoIMPL;

import java.sql.SQLException;

public class Matin {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Workerc workerc=new Workerc();
        workerc.select();
        workerc.selectAll();
        workerc.insert();
    }
}
