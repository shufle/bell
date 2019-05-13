package com.example.bell.controller;


import com.example.bell.service.CountriesService;
import com.example.bell.view.CountriesView;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class CountriesController {

        private final CountriesService countryService;

        @Autowired
        public CountriesController(CountriesService countryService) {
            this.countryService = countryService;
        }

        @RequestMapping(value = "/countries", method = {RequestMethod.GET})
        public List<CountriesView> getAllCountries() {
            return countryService.getAllCountries();
        }

}
