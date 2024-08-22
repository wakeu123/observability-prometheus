package com.moriset.observability.controllers;

import com.moriset.observability.entities.Product;
import com.moriset.observability.models.Post;
import com.moriset.observability.repositories.ProductRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    private RestClient restClient;
    private final ProductRepository productRepository;

    public ProductController(RestClient.Builder restClient, ProductRepository productRepository) {
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> search() {
        return ResponseEntity.ok().body(this.productRepository.findAll());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
       return ResponseEntity.ok().body(
               this.restClient.get()
                       .uri("/posts")
                       .retrieve()
                       .body(new ParameterizedTypeReference<List<Post>>() {})
       );
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(CREATED).body(this.productRepository.save(product));
    }
}
