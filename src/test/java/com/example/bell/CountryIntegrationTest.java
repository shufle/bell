package com.example.bell;

import com.example.bell.view.CountriesView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Интеграционный тест работы справочника стран
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testCountries() {
        ResponseEntity<List<CountriesView>> response = testRestTemplate.exchange( "/api/countries", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CountriesView>>() {
                });
        List<CountriesView> allCountries = response.getBody();
        assertNotNull(allCountries);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        /**В справочнике 4 страны**/
        assertEquals(allCountries.size(),4);
    }
}
