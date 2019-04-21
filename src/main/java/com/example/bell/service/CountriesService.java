package com.example.bell.service;


import com.example.bell.view.CountriesView;

import java.util.List;

/**
 * Сервис справочника стран
 */

public interface CountriesService {


        /**
         * Получить список кодов стран
         *
         */

    List<CountriesView> getAllCountries();

}
