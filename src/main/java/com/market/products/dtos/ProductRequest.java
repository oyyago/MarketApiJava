package com.market.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private @NotNull String product_id;
    private @NotBlank String product_name;
    private String unit_price;
    private int supplier_id;
    private int category_id;
    private @NotNull int stock;
}
