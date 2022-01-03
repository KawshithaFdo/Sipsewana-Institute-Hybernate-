package dao.Dao.Impl;

import dao.CrudDao;
import entity.st_Courses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface St_CourseDaoImpl extends CrudDao<st_Courses,String> {
    List<st_Courses> getdata(String id) throws SQLException, ClassNotFoundException, IOException ;

    }
