package com.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class City {
    @Id
    private Long id;
    private String name;
    @Column(name="country_code")
    private String countryCode;
    private String district;
    private Integer population;

}
