package business;

import business.Factory.SuperBo;
import dto.courses;
import dto.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Studentbo extends SuperBo {
    student search(String text) throws SQLException, ClassNotFoundException, IOException;
    boolean add(student c) throws SQLException, ClassNotFoundException,IOException;
    boolean update(student c) throws SQLException, ClassNotFoundException,IOException;
    boolean delete(String id) throws SQLException, ClassNotFoundException,IOException;
    List<student> getall() throws SQLException, ClassNotFoundException,IOException;

}
