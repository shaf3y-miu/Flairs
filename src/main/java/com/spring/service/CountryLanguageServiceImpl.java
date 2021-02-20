package com.spring.service;

import com.spring.exception.InvalidCountryCode;
import com.spring.model.CountryLanguage;
import com.spring.repository.CountryLanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryLanguageServiceImpl implements  CountryLanguageService{
    @Autowired
    CountryLanguageRepository countryLanguageRepository;
    @Override
    public Optional<CountryLanguage> getCountryLanguage(String countryCode) throws InvalidCountryCode {
        Optional<CountryLanguage> countryLanguage =countryLanguageRepository.findFirstByCountryLanguagePKCountryCodeAndIsOfficialIsTrue(countryCode);
        if(countryLanguage.isPresent())
        return countryLanguage;
        else throw new InvalidCountryCode();
    }
}
