package business.Impl;

import business.St_Coursebo;
import dao.Dao.Impl.St_CourseDaoImpl;
import dao.FactoryDao;
import dto.st_courses;
import entity.st_Courses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class St_CourseboImpl implements St_Coursebo {
    private final St_CourseDaoImpl st = (St_CourseDaoImpl) FactoryDao.getFactoryDao().getDAO(FactoryDao.DAOTypes.ST_COURSE);


    @Override
    public st_courses search(String text) throws SQLException, ClassNotFoundException, IOException {
        entity.st_Courses search = st.search(text);
        return new st_courses(search.getStudent(),search.getName(),search.getCourse(),search.getC_name(),search.getFee());    }

    @Override
    public boolean add(st_courses c) throws SQLException, ClassNotFoundException, IOException {
        return st.add(new st_Courses((c.getName()),c.getC_Name(),c.getFee(),c.getSt_Id(),c.getC_Id()));
    }

    @Override
    public boolean update(st_courses c) throws SQLException, ClassNotFoundException, IOException {
        return st.update(new st_Courses(c.getName(),c.getC_Name(),c.getFee(),c.getSt_Id(),c.getC_Id()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException, IOException {
        return st.delete(id);
    }

    @Override
    public List<st_courses> getall() throws SQLException, ClassNotFoundException, IOException {
        List<entity.st_Courses> all = st.getall();
        ArrayList<st_courses> stdto = new ArrayList<>();

        for (entity.st_Courses stc : all) {
            stdto.add(new st_courses(
                    stc.getStudent(),
                    stc.getName(),
                    stc.getCourse(),
                    stc.getC_name(),
                    stc.getFee()
            ));
        }
        return stdto;
    }

    @Override
    public List<st_courses> getdata(String id) throws SQLException, ClassNotFoundException, IOException {
        List<entity.st_Courses> all = st.getdata(id);
        ArrayList<st_courses> stdto = new ArrayList<>();

        for (entity.st_Courses stc : all) {
            stdto.add(new st_courses(
                    stc.getStudent(),
                    stc.getName(),
                    stc.getCourse(),
                    stc.getC_name(),
                    stc.getFee()
            ));
        }
        return stdto;
    }
}
