package com.moriset.observability.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "Product")
@Table(name = "Product")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 8879146216395236873L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
