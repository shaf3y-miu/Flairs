package com.spring.service;


import com.spring.exception.InvalidCountryCode;
import com.spring.model.CountryDto;


public interface CountryService {
    CountryDto getCountry(String countryCode) throws InvalidCountryCode;
}
