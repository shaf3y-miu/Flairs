package com.spring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDto {
    private String name;
    private String continent;
    private Integer population;
    private double life_expectancy;
    private String country_language;
}
