package view.tm;

public class courseTm {
    private String c_Id;
    private String name;
    private String duration;
    private String fee;

    public courseTm() {
    }

    public courseTm(String c_Id, String name, String duration, String fee) {
        this.c_Id = c_Id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
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
}
