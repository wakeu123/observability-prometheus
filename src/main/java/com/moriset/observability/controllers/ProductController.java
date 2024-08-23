package com.moriset.observability.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.moriset.observability.entities.models.Post;
import com.moriset.observability.services.ProductService;
import com.moriset.observability.entities.dtos.ProductDto;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;

@Validated
@RestController
@RequestMapping(path = "products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> search() {
        return ResponseEntity.ok().body(this.productService.search());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
       return ResponseEntity.ok().body(this.productService.searchPost());
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.status(CREATED).body(this.productService.save(dto));
    }
}
