package view.tm;

import entity.Student;
import entity.courses;

import javax.persistence.Entity;

public class st_courseTm {
    private String St_Id;
    private String name;
    private String c_Id;
    private String fee;

    public st_courseTm() {
    }

    public st_courseTm(String st_Id, String name, String c_Id, String fee) {
        St_Id = st_Id;
        this.name = name;
        this.c_Id = c_Id;
        this.fee = fee;
    }

    public String getSt_Id() {
        return St_Id;
    }

    public void setSt_Id(String st_Id) {
        St_Id = st_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_Id() {
        return c_Id;
    }

    public void setC_Id(String c_Id) {
        this.c_Id = c_Id;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
