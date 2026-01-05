package com.farmtech.product.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    ACTIVE,
    INACTIVE,
    DISCONTINUED,
    IN_TESTING;

    @JsonCreator
    public static Status fromString(String value) {
        if (value == null) {
            return null;
        }

        try {
            return Status.valueOf(
                value.trim().toUpperCase().replace(" ", "_")
            );
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                "Invalid value for status. Allowed values: ACTIVE, INACTIVE, IN_TESTING, DISCONTINUED"
            );
        }
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}