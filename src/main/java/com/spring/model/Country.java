package com.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Country {
    @Id
    private String code;

    private String name;

    private String continent;

    private String region;

    @Column(name="surface_area")
    private Double surfaceArea;

    @Column(name="indep_year")
    private Short indepYear;

    private Integer population;

    @Column(name="life_expectancy")
    private Double lifeExpectancy;

    private Long gnp;

    @Column(name="gnp_old")
    private Long gnpOld;

    @Column(name="local_name")
    private String localName;

    @Column(name="government_form")
    private String governmentForm;

    @Column(name="head_of_state")
    private String headOfState;

    private String capital;

    private String code2;

}

