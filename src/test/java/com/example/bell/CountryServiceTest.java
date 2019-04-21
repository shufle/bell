package com.example.bell;

import com.example.bell.dao.CountriesDao;
import com.example.bell.model.Country;
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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {

	@Mock
	CountriesDao dao;

	@InjectMocks
	CountriesServiceImpl countriesService;

	List<Country> countries;

	@Before
	public void setupTestCountry() {
		countries = new ArrayList<>();
		countries.add(new Country("USA", 666L));
		countries.add(new Country("Russia", 777L));
	}

	@Test
	public void CountryServiceTest()  {

		when(dao.findAll()).thenReturn(countries);
		List<CountriesView> allCountries = countriesService.getAllCountries();
		verify(dao).findAll();
		assertNotNull(allCountries);
		assertEquals(allCountries.size(),countries.size());
		assertEquals(allCountries.get(0).name,countries.get(0).getName());

	}

}
