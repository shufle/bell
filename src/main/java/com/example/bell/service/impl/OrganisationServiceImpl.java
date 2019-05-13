package com.example.bell.service.impl;

import com.example.bell.service.OrganisationService;
import com.example.bell.view.*;
import com.example.bell.view.Organisation.OrganisationFilter;
import com.example.bell.view.Organisation.OrganisationView;
import com.example.bell.view.Organisation.SaveOrganisationInfo;
import com.example.bell.view.Organisation.UpdateOrganisationInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    @Override
    public List<OrganisationView> list(OrganisationFilter filter) {
        return null;
    }

    @Override
    public OrganisationView getOrganisationById(Long id) {
        return null;
    }

    @Override
    public ResultView updateOrganisation(UpdateOrganisationInfo info) {
        return null;
    }

    @Override
    public ResultView saveOrganisation(SaveOrganisationInfo info) {
        return null;
    }
}
