package com.example.bell;

import com.example.bell.controller.CountriesController;
import com.example.bell.service.CountriesServiceImpl;
import com.example.bell.view.CountriesView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {
    @Mock
    CountriesServiceImpl countriesService;

    @InjectMocks
    CountriesController countriesController;

    List<CountriesView> countriesViews;

    @Before
    public void setupTest() {
       countriesViews = new ArrayList<>();
       countriesViews.add(new CountriesView("USA",777L));
       countriesViews.add(new CountriesView("222",789L));
       countriesViews.add(new CountriesView("jkkk",654L));
    }

    @Test
    public void CountryControllerTest() {
        when(countriesService.getAllCountries()).thenReturn(countriesViews);
        List<CountriesView> allCountries = countriesController.getAllCountries();
        verify(countriesService).getAllCountries();
        assertNotNull(allCountries);
        assertEquals(allCountries.size(),countriesViews.size());
        assertEquals(allCountries.get(1),countriesViews.get(1));
    }


}
