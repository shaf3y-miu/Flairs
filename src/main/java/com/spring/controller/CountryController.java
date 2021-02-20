package com.spring.controller;


import com.spring.exception.InvalidCountryCode;
import com.spring.model.CountryDto;
import com.spring.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/{code}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable String code) {
        try {
            CountryDto country = countryService.getCountry(code);
            return new ResponseEntity(country, HttpStatus.OK);
        }
        catch (InvalidCountryCode exception){
            return new ResponseEntity("INVALID_COUNTRY_CODE", HttpStatus.INTERNAL_SERVER_ERROR);

        }catch (DataAccessResourceFailureException exception){
            return new ResponseEntity("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
