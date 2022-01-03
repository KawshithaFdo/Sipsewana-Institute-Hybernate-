package business.Impl;

import business.Coursebo;
import dao.Dao.Impl.CourseDaoImpl;
import dao.FactoryDao;
import dto.courses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseboImpl implements Coursebo {

    private final CourseDaoImpl co = (CourseDaoImpl) FactoryDao.getFactoryDao().getDAO(FactoryDao.DAOTypes.COURSE);

    @Override
    public courses search(String text) throws SQLException, ClassNotFoundException, IOException {
        entity.courses search = co.search(text);
        return new courses(search.getC_Id(),search.getName(),search.getDuration(),search.getFee());
    }

    @Override
    public boolean add(courses c) throws SQLException, ClassNotFoundException, IOException {
        return co.add(new entity.courses(c.getC_Id(),c.getName(),c.getDuration(),c.getFee()));
    }

    @Override
    public boolean update(courses c) throws SQLException, ClassNotFoundException, IOException {
        return co.update(new entity.courses(c.getC_Id(),c.getName(),c.getDuration(),c.getFee()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        return co.delete(id);
    }

    @Override
    public List<courses> getall() throws SQLException, ClassNotFoundException, IOException {
        List<entity.courses> all = co.getall();
        ArrayList<courses> coursedto = new ArrayList<>();

        for (entity.courses courses : all) {
            coursedto.add(new courses(
                    courses.getC_Id(),
                    courses.getName(),
                    courses.getDuration(),
                    courses.getFee()
            ));
        }
        return coursedto;
    }
}
