package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class courses {
    @Id
    @Column(name = "C_ID")
    private String c_Id;
    private String name;
    private String duration;
    private String fee;

    @OneToMany(mappedBy = "course")
    private List<st_Courses> st_courses;

    public courses() {
    }

    public courses(String c_Id, String name, String duration, String fee) {
        this.c_Id = c_Id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public List<st_Courses> getSt_courses() {
        return st_courses;
    }

    public void setSt_courses(List<st_Courses> st_courses) {
        this.st_courses = st_courses;
    }

    public String getC_Id() {
        return c_Id;
    }

    public void setC_Id(String c_Id) {
        this.c_Id = c_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "courses{" +
                "c_Id='" + c_Id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
