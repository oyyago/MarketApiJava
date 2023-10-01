package com.market.products.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse{
    String productId;
    String product_name;
    private String unit_price;
    int supplier_id;
    int category_id;
    int stock;
}