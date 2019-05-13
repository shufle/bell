package com.example.bell.controller;


import com.example.bell.service.OrganisationService;
import com.example.bell.view.*;
import com.example.bell.view.Organisation.OrganisationFilter;
import com.example.bell.view.Organisation.OrganisationView;
import com.example.bell.view.Organisation.SaveOrganisationInfo;
import com.example.bell.view.Organisation.UpdateOrganisationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganisationController {

    private OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public List<OrganisationView> getOfficeByFilter(@RequestBody OrganisationFilter filter) {return organisationService.list(filter);}

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public OrganisationView getOrganisation(@PathVariable("id") long orgId) {
        return organisationService.getOrganisationById(orgId);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public ResultView updateOrganisation(@RequestBody UpdateOrganisationInfo info) {return organisationService.updateOrganisation(info);}

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ResultView saveOrganization(@RequestBody SaveOrganisationInfo info) {return organisationService.saveOrganisation(info);}

}
