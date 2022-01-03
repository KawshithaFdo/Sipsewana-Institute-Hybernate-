package business.Factory;
import business.Impl.CourseboImpl;
import business.Impl.St_CourseboImpl;
import business.Impl.StudentboImpl;

public class FactoryBo {
    private static FactoryBo Factorybo;

    private FactoryBo() {
    }

    public static FactoryBo getFactoryBo() {
        if (Factorybo == null) {
            Factorybo = new FactoryBo();
        }
        return Factorybo;
    }

    //factory method
    public SuperBo getBO(BOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentboImpl();
            case COURSE:
                return new CourseboImpl() {
                };
            case ST_COURSE:
                return new St_CourseboImpl();
            default:
                return null;
        }
    }

    public enum BOTypes {
        STUDENT, COURSE, ST_COURSE
    }
}
