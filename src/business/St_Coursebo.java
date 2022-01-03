package business;

import business.Factory.SuperBo;
import dto.st_courses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface St_Coursebo extends SuperBo {
    st_courses search(String text) throws SQLException, ClassNotFoundException, IOException;
    boolean add(st_courses c) throws SQLException, ClassNotFoundException,IOException;
    boolean update(st_courses c) throws SQLException, ClassNotFoundException,IOException;
    boolean delete(String id) throws SQLException, ClassNotFoundException,IOException;
    List<st_courses> getall() throws SQLException, ClassNotFoundException,IOException;
    List<st_courses> getdata(String id) throws SQLException, ClassNotFoundException, IOException ;

    }
