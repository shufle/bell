package com.example.bell.service;

import com.example.bell.dao.CountriesDao;
import com.example.bell.model.Country;
import com.example.bell.view.CountriesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CountriesServiceImpl implements  CountriesService {

    private final CountriesDao dao;

    @Autowired
    public CountriesServiceImpl(CountriesDao dao) {
        this.dao = dao;
    }


    @Override
    public List<CountriesView> getAllCountries() {
        List<Country> countries = dao.findAll();

        //Функция создания CountriesView на ознове Country
        Function<Country, CountriesView> mapCountry = c -> {
            CountriesView countryView = new CountriesView();
            countryView.name = c.getName();
            countryView.code = c.getCode();
            return countryView;
        };
        return countries.stream().map(mapCountry).collect(Collectors.toList());
    }
}
