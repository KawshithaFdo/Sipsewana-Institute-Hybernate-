package dao.Dao;

import dao.Dao.Impl.St_CourseDaoImpl;
import entity.Student;
import entity.courses;
import entity.st_Courses;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class St_CourseDao implements St_CourseDaoImpl {
    @Override
    public boolean add(st_Courses st_courses) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(st_courses);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(st_Courses st_courses) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(st_courses);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        st_Courses st = session.get(st_Courses.class, s);

        session.delete(st);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public st_Courses search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        st_Courses c = session.get(st_Courses.class, s);

        transaction.commit();
        session.close();
        return c;
    }

    @Override
    public List<st_Courses> getall() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<st_Courses> list = null;

        Query st = session.createQuery("from st_courses");
        list = st.list();

        transaction.commit();

        session.close();
        return list;
    }

    @Override
    public List<st_Courses> getdata(String id) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<st_Courses> list = null;

        Query st = session.createQuery("from st_courses  where St_Id=id");
        list = st.list();

        transaction.commit();

        session.close();
        return list;
    }

}
