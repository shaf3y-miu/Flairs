package com.spring.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country_language")
@Data
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguagePK countryLanguagePK;

    @Column(name = "is_official")
    private boolean isOfficial;

    private double percentage;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CountryLanguagePK implements Serializable {
        @Column(name = "country_code")
        protected String countryCode;

        protected String language;

    }
}