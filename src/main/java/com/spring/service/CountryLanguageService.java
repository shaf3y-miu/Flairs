package com.spring.service;

import com.spring.exception.InvalidCountryCode;
import com.spring.model.CountryLanguage;

import java.util.Optional;

public interface CountryLanguageService {
    Optional<CountryLanguage> getCountryLanguage(String countryCode) throws InvalidCountryCode;
}
