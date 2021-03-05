package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    private String name;
    private Integer quantity;
    private BigDecimal stockPrice;
}
