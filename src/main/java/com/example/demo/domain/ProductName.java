package com.example.demo.domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.Objects;

public class ProductName {
    private final String name;

    public static ProductName of(String value) {
        return new ProductName(value);
    }

    private ProductName(String name) {
        Validate.notNull(name, "El nombre del producto no puede ser nulo");
        Validate.isTrue(StringUtils.isNotBlank(name), "El nombre del producto no puede estar vacio.");
        Validate.isTrue(name.length() <= 128, "El tamaño del nombre de producto no puede ser mayor a 128");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductName that = (ProductName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ProductName{" +
                "name='" + name + '\'' +
                '}';
    }
}
