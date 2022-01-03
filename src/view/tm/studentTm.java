package view.tm;

public class studentTm {
    private String st_id;
    private String name;
    private String address;
    private String contact;

    public studentTm() {
    }

    public studentTm(String st_id, String name, String address, String contact) {
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
}
