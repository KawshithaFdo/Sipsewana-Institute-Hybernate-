package dao.Dao;

import dao.Dao.Impl.StudentDaoImpl;
import entity.Student;
import entity.courses;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements StudentDaoImpl {
    @Override
    public boolean add(Student student) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, s);

        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student st = session.get(Student.class, s);

        transaction.commit();
        session.close();
        return st;
    }

    @Override
    public List<Student> getall() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = null;

        Query students = session.createQuery("from Student");
        list = students.list();

        transaction.commit();

        session.close();
        return list;
    }
}
