package com.example.bell.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table (name= "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_head")
    private boolean isHead;

    @ManyToMany(
            mappedBy = "office",
            cascade = CascadeType.ALL
    )
    List<Organisation> organisations;

    public Office() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }
}
