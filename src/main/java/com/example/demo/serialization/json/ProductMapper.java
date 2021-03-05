package com.example.demo.serialization.json;

import com.example.demo.domain.Product;
import com.example.demo.domain.ProductName;
import com.example.demo.domain.ProductPrice;
import com.example.demo.model.CreateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        imports = {
                ProductName.class,
                ProductPrice.class
        }
)
public interface ProductMapper {

    @Mapping(target = "availableQuantity", source = "quantity")
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "name", expression = "java(ProductName.of(input.getName()))")
    @Mapping(target = "stockPrice", expression = "java(ProductPrice.of(input.getStockPrice()))")
    Product fromDto(CreateProductRequest input);
}
