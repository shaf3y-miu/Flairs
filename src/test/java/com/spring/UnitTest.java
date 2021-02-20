package com.spring;

import com.spring.controller.CountryController;
import com.spring.exception.InvalidCountryCode;
import com.spring.service.CountryService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
class UnitTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void invalidCountryCodeTest() throws Exception{

            // simulate service response in case of invalid code
            when(countryService.getCountry("invalidCode")).thenThrow(new InvalidCountryCode());
            mvc.perform(get("/invalidCode"))
                    .andExpect(status().isInternalServerError())
                    .andExpect((ResultMatcher) content().string("INVALID_COUNTRY_CODE"))
            ;

    }
    @Test
    public void databaseConnectionDownTest() throws Exception{

            // simulate service response in case of database down
            when(countryService.getCountry("BHR"))
                    .thenThrow(new DataAccessResourceFailureException("INTERNAL_ERROR"));

            mvc.perform(get("/BHR"))
                    .andExpect(status().isInternalServerError())
                    .andExpect((ResultMatcher) content().string("INTERNAL_ERROR"));
    }



}
