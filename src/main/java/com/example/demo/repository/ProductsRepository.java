package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository {

    Product saveProduct(Product product);
}
