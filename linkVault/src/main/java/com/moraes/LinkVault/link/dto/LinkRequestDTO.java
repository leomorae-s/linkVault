package com.moraes.LinkVault.link.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LinkRequestDTO(
    @NotBlank
    @URL
    String link,
    @Size(max = 255)
    String description
) {}
