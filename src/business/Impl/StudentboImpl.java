package business.Impl;

import business.Studentbo;
import dao.Dao.Impl.CourseDaoImpl;
import dao.Dao.Impl.StudentDaoImpl;
import dao.FactoryDao;
import dto.courses;
import dto.student;
import entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentboImpl implements Studentbo {

    private final StudentDaoImpl st = (StudentDaoImpl) FactoryDao.getFactoryDao().getDAO(FactoryDao.DAOTypes.STUDENT);


    @Override
    public student search(String text) throws SQLException, ClassNotFoundException, IOException {
        entity.Student search = st.search(text);
        return new student(search.getSt_id(),search.getName(),search.getAddress(),search.getContact());
    }

    @Override
    public boolean add(student c) throws SQLException, ClassNotFoundException, IOException {
        return st.add(new Student(c.getSt_id(),c.getName(),c.getAddress(),c.getContact()));
    }

    @Override
    public boolean update(student c) throws SQLException, ClassNotFoundException, IOException {
        return st.update(new Student(c.getSt_id(),c.getName(),c.getAddress(),c.getContact()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        return st.delete(id);
    }

    @Override
    public List<student> getall() throws SQLException, ClassNotFoundException, IOException {
        List<entity.Student> all = st.getall();
        ArrayList<student> stdto = new ArrayList<>();

        for (entity.Student student : all) {
            stdto.add(new student(
                   student.getSt_id(),
                   student.getName(),
                   student.getAddress(),
                   student.getContact()
            ));
        }
        return stdto;
    }
}
