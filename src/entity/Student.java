package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name = "St_ID")
    private String st_id;
    private String name;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "student")
    private List<st_Courses> st_courses;


    public Student() {
    }

    public Student(String st_id, String name, String address, String contact) {
        this.st_id = st_id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<st_Courses> getSt_courses() {
        return st_courses;
    }

    public void setSt_courses(List<st_Courses> st_courses) {
        this.st_courses = st_courses;
    }
}
