package com.spring.repository;

import com.spring.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
    Optional<CountryLanguage> findFirstByCountryLanguagePKCountryCodeAndIsOfficialIsTrue(String countryCode);
}
