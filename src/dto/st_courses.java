package dto;

import entity.Student;
import entity.courses;

public class st_courses {
    private Student St_Id;
    private String name;
    private entity.courses c_Id;
    private String c_Name;
    private String fee;

    public st_courses() {
    }

    public st_courses(Student st_Id, String name, courses c_Id, String c_Name, String fee) {
        St_Id = st_Id;
        this.name = name;
        this.c_Id = c_Id;
        this.c_Name = c_Name;
        this.fee = fee;
    }

    public Student getSt_Id() {
        return St_Id;
    }

    public void setSt_Id(Student st_Id) {
        St_Id = st_Id;
    }

    public courses getC_Id() {
        return c_Id;
    }

    public void setC_Id(courses c_Id) {
        this.c_Id = c_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
