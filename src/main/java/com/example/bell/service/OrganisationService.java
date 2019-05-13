package com.example.bell.service;

import com.example.bell.view.*;
import com.example.bell.view.Organisation.OrganisationFilter;
import com.example.bell.view.Organisation.OrganisationView;
import com.example.bell.view.Organisation.SaveOrganisationInfo;
import com.example.bell.view.Organisation.UpdateOrganisationInfo;

import java.util.List;

public interface OrganisationService {

    List<OrganisationView> list(OrganisationFilter filter);

    OrganisationView getOrganisationById(Long id);

    ResultView updateOrganisation(UpdateOrganisationInfo info);

    ResultView saveOrganisation(SaveOrganisationInfo info);
}
