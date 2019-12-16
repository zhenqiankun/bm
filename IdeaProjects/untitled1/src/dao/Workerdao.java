package dao;

import java.sql.SQLException;

public interface Workerdao {
    public void  select() throws SQLException;
    public void selectAll() throws SQLException;
    public void insert() throws SQLException;
}
