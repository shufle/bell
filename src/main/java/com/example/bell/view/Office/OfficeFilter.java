package com.example.bell.view.Office;

/**
 * Данные запроса на Office
 */
public class OfficeFilter {
    public long orgId;
    public String name;
    public String phone;
    public boolean isActive;

    public OfficeFilter(long orgId, String name, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeFilter(long orgId) {
        this.orgId = orgId;
    }
}
