package com.moriset.observability.config;

import com.moriset.observability.entities.Product;
import com.moriset.observability.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class initializeValue implements CommandLineRunner {

    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Product("Phone", 2500.0));
        repository.save(new Product("Arduino", 15000.0));
        repository.save(new Product("Couteau", 25250.0));
        repository.save(new Product("Spot", 21580.0));
        repository.save(new Product("Television", 852200.0));
    }
}
