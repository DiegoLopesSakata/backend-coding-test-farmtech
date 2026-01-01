package com.farmtech.product.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Farmer {

    @NotBlank
    private String document;

    @NotBlank
    private String farmName;

    @NotBlank
    @Size(min = 2, max = 2)
    private String state;

    public String getDocument() {
        return document;
    }

    public String getFarmName() {
        return farmName;
    }

    public String getState() {
        return state;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void setState(String state) {
        this.state = state;
    }
}

