package com.example.bell.model;

import javax.persistence.*;

@Entity
@Table(name = "Doc_codes")
public class Doc {

    @Id
    @Column(name = "code")
    private long code;

    @Version
    private Integer version;

    @Column (name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Document document;

    public Doc() {
    }

    public Doc(long code, String name) {
        this.code = code;
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
