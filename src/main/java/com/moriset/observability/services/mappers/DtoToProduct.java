package com.moriset.observability.services.mappers;

import org.springframework.stereotype.Component;
import com.moriset.observability.entities.Product;
import com.moriset.observability.entities.dtos.ProductDto;

import java.util.function.Function;

@Component
public class DtoToProduct implements Function<ProductDto, Product> {

    @Override
    public Product apply(ProductDto dto) {
        return new Product(dto.productName(), dto.productPrice());
    }
}
