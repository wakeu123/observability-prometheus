package com.moriset.observability.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record ProductDto(
        Long id,
        @NotBlank(message = "")
        @Size(min = 2, max = 30, message = "Le nom doit comporter entre 2 et 30 caractères")
        String productName,
        @NotBlank(message = "")
        Double productPrice
) { }
