package com.example.bell.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Organisation")
public class Organisation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "inn", length = 12)
    private String inn;

    @Column(name = "kpp", length = 9)
    private String kpp;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "OFFICE_ORGANIZATION",
            joinColumns = {@JoinColumn(name = "organization_id")},
            inverseJoinColumns = {@JoinColumn(name = "office_id")})
    private List<Office> offices ;

    public Organisation() {
    }

    public Organisation(Integer version, String fullName, String inn, String kpp, List<Office> offices) {
        this.version = version;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.offices = offices;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }
}
