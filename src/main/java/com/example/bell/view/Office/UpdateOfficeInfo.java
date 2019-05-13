package com.example.bell.view.Office;

public class UpdateOfficeInfo {
    public long id;
    public String name;
    public String address;
    public String phone;
    public boolean isActive = true;

    public UpdateOfficeInfo(long id, String name, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public UpdateOfficeInfo(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
