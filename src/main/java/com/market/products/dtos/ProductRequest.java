package com.market.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(@NotBlank String product_name, @NotBlank String unite_price,
                             int supplier_id, int category_id, @NotNull int stock) {

}
