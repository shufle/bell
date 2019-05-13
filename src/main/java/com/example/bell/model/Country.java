package com.example.bell.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

/**
 * Таблица стран
 */
@Entity
@Table(name = "Country_codes")
public class Country {


    /**
     * Код страны, используется в качестве ID
     */
    @Id
    @Column(name = "code")
    private Long code;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Название страны
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "citizenship_code")
    private List<User> users;

    /**
     * Пустой конструктор для hibernate
     */
    public Country() {
    }

    public Country(String name, Long code) {
        this.name = name;
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

}