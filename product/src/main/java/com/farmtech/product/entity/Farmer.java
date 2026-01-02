package com.farmtech.product.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Farmer {

    @NotBlank(message="Farmer document is required")
    private String document;

    @NotBlank(message="Farm name is required")
    private String farmName;

    @NotBlank(message="State is required")
    @Size(min = 2, max = 2, message="State must have exactly 2 characters")
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

