package com.moriset.observability.services.mappers;

import org.springframework.stereotype.Component;
import com.moriset.observability.entities.Product;
import com.moriset.observability.entities.dtos.ProductDto;

import java.util.function.Function;

@Component
public class ProductToDto implements Function<Product, ProductDto> {

    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
