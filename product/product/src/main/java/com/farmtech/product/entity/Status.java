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

        return Status.valueOf(
            value
                .trim()
                .toUpperCase()
                .replace(" ", "_")
        );
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}