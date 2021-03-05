package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository repository;

    public Product storeProduct(Product product) {
        return repository.saveProduct(product);
    }


    public static Float calculateBusinessPrice(Float stockPrice) {
        return stockPrice * 0.2f;
    }
}
