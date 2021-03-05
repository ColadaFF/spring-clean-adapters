package com.example.demo.domain;

import lombok.Value;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class ProductPrice {
    BigDecimal value;

    private ProductPrice(BigDecimal value) {
        Validate.notNull(value, "El precio del producto no puede ser nulo");
        Validate.isTrue(isGreaterThan0(value), "El precio del producto debe ser mayor a 0");
        this.value = value;
    }

    private static boolean isGreaterThan0(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }
}
