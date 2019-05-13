package com.example.bell.view;

public class DocsView {

    public long code;
    public  String name;

    public DocsView() {
    }

    /**
     * Конструктор для тестов
     * @param code код документа
     * @param name название документа
     */
    public DocsView(long code, String name) {
        this.code = code;
        this.name = name;
    }
}
