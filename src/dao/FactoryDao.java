package dao;

import dao.Dao.*;

public class FactoryDao {
    private static FactoryDao Factorydao;

    private FactoryDao() {
    }

    public static FactoryDao getFactoryDao() {
        if (Factorydao == null) {
            Factorydao = new FactoryDao();
        }
        return Factorydao;
    }

    //factory method
    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDao();
            case COURSE:
                return new CourseDao();
            case ST_COURSE:
                return new St_CourseDao();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        STUDENT, COURSE, ST_COURSE
    }
}
