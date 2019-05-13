package com.example.bell.view.Organisation;

public class OrganisationFilter {

    public String name;
    public String inn;
    public boolean isActive;

    public OrganisationFilter(String name, String inn, boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }
}
