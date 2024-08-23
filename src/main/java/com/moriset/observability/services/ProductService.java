package com.moriset.observability.services;

import com.moriset.observability.entities.dtos.ProductDto;
import com.moriset.observability.entities.models.Post;

import java.util.List;

public interface ProductService {

    public List<Post> searchPost();
    public List<ProductDto> search();
    public ProductDto save(ProductDto dto);
}
