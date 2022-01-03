package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T,ID> extends SuperDao {
     boolean add(T t) throws SQLException, ClassNotFoundException, IOException;
     boolean update(T t) throws SQLException, ClassNotFoundException, IOException;
     boolean delete(ID id) throws SQLException, ClassNotFoundException, IOException;
     T search(ID id) throws SQLException, ClassNotFoundException, IOException;
     List<T> getall() throws SQLException, ClassNotFoundException, IOException;
}
