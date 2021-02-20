package com.spring.service;

import com.spring.exception.InvalidCountryCode;
import com.spring.model.Country;
import com.spring.model.CountryDto;
import com.spring.model.CountryLanguage;
import com.spring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    CountryLanguageService countryLanguageService;

    @Override
    public CountryDto getCountry(String countryCode) throws InvalidCountryCode {
       Optional<Country> country = countryRepository.findByCode(countryCode);
       if(!country.isPresent())
        throw new InvalidCountryCode();
       Optional<CountryLanguage> countryLanguage = countryLanguageService.getCountryLanguage(countryCode);

        String language = countryLanguage.get().getCountryLanguagePK().getLanguage();

        return CountryDto.builder()
                .name(country.get().getName())
                .continent(country.get().getContinent())
                .population(country.get().getPopulation())
                .life_expectancy(country.get().getLifeExpectancy())
                .country_language(language)
                .build();
    }

}
