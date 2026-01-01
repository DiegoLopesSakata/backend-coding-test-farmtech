package com.farmtech.product.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Farmer {

    @NotBlank
    private String document;

    @NotBlank
    private String farmName;

    @NotBlank
    @Size(min = 2, max = 2)
    private String state;

}

