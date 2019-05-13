package com.example.bell.service;

import com.example.bell.view.DocsView;

import java.util.List;

public interface DocsService {



    /**
     * Получить список кодов стран
     *
     */

    List<DocsView> getAllDocs();
}
