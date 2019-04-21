package com.example.bell.dao;


import com.example.bell.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesDao extends JpaRepository<Country, Long> {

}