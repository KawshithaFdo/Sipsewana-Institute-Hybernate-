package dao.Dao;

import dao.Dao.Impl.CourseDaoImpl;
import entity.courses;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CourseDao implements CourseDaoImpl {
    @Override
    public boolean add(courses courses) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(courses);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(courses courses) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(courses);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        courses c = session.get(courses.class, s);

        session.delete(c);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public courses search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        courses c = session.get(courses.class, s);

        transaction.commit();
        session.close();
        return c;
    }

    @Override
    public List<courses> getall() throws SQLException, ClassNotFoundException, IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<courses> list = null;

        Query c = session.createQuery("from courses");
        list = c.list();

        transaction.commit();

        session.close();
        return list;
    }
}
