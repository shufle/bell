package com.example.bell.controller;

import com.example.bell.service.DocsService;
import com.example.bell.view.DocsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocsController {
    private final DocsService docsService;

    @Autowired
    public DocsController(DocsService docsService) {
        this.docsService = docsService;
    }

    @RequestMapping(value = "/docs", method = {RequestMethod.GET})
    public List<DocsView> getAllDocs() {
        return docsService.getAllDocs();
    }
}








