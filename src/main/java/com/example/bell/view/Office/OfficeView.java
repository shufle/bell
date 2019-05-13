package com.example.bell.view.Office;

public class OfficeView {
    public long id;
    public String name;
    public String address;
    public String phone;
    public boolean isActive;

    public OfficeView(long id, String name, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
