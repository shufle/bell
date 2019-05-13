package com.example.bell.controller;


import com.example.bell.service.OfficeService;
import com.example.bell.view.*;
import com.example.bell.view.Office.OfficeFilter;
import com.example.bell.view.Office.OfficeView;
import com.example.bell.view.Office.SaveOfficeInfo;
import com.example.bell.view.Office.UpdateOfficeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping (value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public List<OfficeView> getOfficeByFilter(@RequestBody OfficeFilter filter) {return officeService.list(filter);}

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public OfficeView getOffice(@PathVariable ("id") long officeId) {
        return officeService.getOfficeById(officeId);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public ResultView updateOffice(@RequestBody UpdateOfficeInfo info) {return officeService.updateOffice(info);}

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ResultView saveOffice(@RequestBody SaveOfficeInfo info) {return officeService.saveOffice(info);}

}
