package com.example.demo.domain;

import org.apache.commons.lang3.Validate;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final ProductName name;
    private final Integer availableQuantity;
    private final ProductPrice stockPrice;

    public Product(UUID id, ProductName name, Integer availableQuantity, ProductPrice stockPrice) {
        this.id = Validate.notNull(id, "id no puede ser null");
        this.name = Validate.notNull(name, "name no puede ser null");
        this.availableQuantity = Validate.notNull(availableQuantity, "availableQuantity no puede ser null");
        this.stockPrice = Validate.notNull(stockPrice, "stockPrice no puede ser null");
    }

    public ProductName getName() {
        return name;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }


    public ProductPrice getStockPrice() {
        return stockPrice;
    }

    public UUID getId() {
        return id;
    }
}
