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
    private @NotNull Integer productId;
    private @NotBlank String productName;
    private String unitPrice;
    private int supplierId;
    private int categoryId;
    private @NotNull int stock;
}