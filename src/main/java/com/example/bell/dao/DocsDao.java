package com.example.bell.dao;


import com.example.bell.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocsDao extends JpaRepository<Doc, Long> {

}