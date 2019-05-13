package com.example.bell.model;

import javax.persistence.*;

@Entity
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "number", length = 50)
    private String number;

    @Column(name = "date", length = 50)
    private String date;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "is_identified")
    private boolean isIdentified;

    @Column(name = "code")
    private long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Doc doc;

    /**
     * Пустой конструктор для hibernate
     */
    public Document() {
    }

    public Document(Integer version, String number, String date, String name, boolean isIdentified, long code, Doc doc) {
        this.version = version;
        this.number = number;
        this.date = date;
        this.name = name;
        this.isIdentified = isIdentified;
        this.code = code;
        this.doc = doc;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }
}

