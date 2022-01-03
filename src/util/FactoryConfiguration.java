package util;

import entity.Student;
import entity.courses;
import entity.st_Courses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/hibernate.properties"));
        Configuration configuration = new Configuration().addProperties(properties).addAnnotatedClass(courses.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(st_Courses.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
