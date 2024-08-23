package com.moriset.observability.services.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.moriset.observability.entities.Product;
import com.moriset.observability.entities.models.Post;
import com.moriset.observability.services.ProductService;
import com.moriset.observability.entities.dtos.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import com.moriset.observability.services.mappers.DtoToProduct;
import com.moriset.observability.services.mappers.ProductToDto;
import com.moriset.observability.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private RestClient restClient;
    private ProductToDto productToDto;
    private DtoToProduct dtoToProduct;
    private ProductRepository productRepository;

    public ProductServiceImpl(RestClient restClient, ProductToDto productToDto, DtoToProduct dtoToProduct, ProductRepository productRepository) {
        this.restClient = restClient;
        this.productToDto = productToDto;
        this.dtoToProduct = dtoToProduct;
        this.productRepository = productRepository;
    }

    @Override
    public List<Post> searchPost() {
        return this.restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    @Override
    public List<ProductDto> search() {
        return this.productRepository.findAll().stream()
                .map(productToDto::apply)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto dto) {
        Product product = this.productRepository.save(dtoToProduct.apply(dto));
        return productToDto.apply(product);
    }
}
