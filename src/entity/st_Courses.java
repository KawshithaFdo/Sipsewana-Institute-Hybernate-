package entity;

import javax.persistence.*;

@Entity(name = "st_courses")
public class st_Courses {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String c_name;
    private String fee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "St_ID")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_ID")
    private courses course;


    public st_Courses() {
    }

    public st_Courses(String name, String c_name, String fee, Student student, courses course) {
        this.setName(name);
        this.setC_name(c_name);
        this.setFee(fee);
        this.setStudent(student);
        this.setCourse(course);
    }

    public st_Courses(Long id, String name, String c_name, String fee, Student student, courses course) {
        this.id = id;
        this.name = name;
        this.c_name = c_name;
        this.fee = fee;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public courses getCourse() {
        return course;
    }

    public void setCourse(courses course) {
        this.course = course;
    }
}
