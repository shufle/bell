package com.example.bell.service.impl;

import com.example.bell.dao.DocsDao;
import com.example.bell.model.Doc;
import com.example.bell.service.DocsService;
import com.example.bell.view.DocsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DocsServiceImpl implements DocsService {

    private final DocsDao dao;

    @Autowired
    public DocsServiceImpl(DocsDao dao) {
        this.dao = dao;
    }


    @Override
    public List<DocsView> getAllDocs() {
        List<Doc> docs = dao.findAll();

        //Функция создания DocsView на ознове Doc
        Function<Doc, DocsView> mapDoc = c -> {
            DocsView docsView = new DocsView();
            docsView.name = c.getName();
            docsView.code = c.getCode();
            return docsView;
        };
        return docs.stream().map(mapDoc).collect(Collectors.toList());
    }

}
