package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.model.CreateProductRequest;
import com.example.demo.serialization.json.ProductMapper;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductController {
    private final ProductService productService;
    private final ProductMapper mapper;

    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequest createProductRequest) {
        Product product = mapper.fromDto(createProductRequest);
        return productService.storeProduct(product);
    }
}
