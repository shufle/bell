package com.example.bell.view.Office;

public class SaveOfficeInfo {
    public long orgId;
    public String name;
    public String address;
    public String phone;
    public boolean isActive = true;

    public SaveOfficeInfo(long orgId, String name, String address, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public SaveOfficeInfo(long orgId) {
        this.orgId = orgId;
    }
}
