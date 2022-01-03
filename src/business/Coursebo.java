package business;

import business.Factory.SuperBo;
import dto.courses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Coursebo extends SuperBo {
    courses search(String text) throws SQLException, ClassNotFoundException, IOException;
    boolean add(courses c) throws SQLException, ClassNotFoundException,IOException;
    boolean update(courses c) throws SQLException, ClassNotFoundException,IOException;
    boolean delete(String id) throws SQLException, ClassNotFoundException,IOException;
    List<courses> getall() throws SQLException, ClassNotFoundException,IOException;

}
