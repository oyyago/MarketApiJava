package com.market.products.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse{
    Integer productId;
    String productName;
    String unitPrice;
    int supplierId;
    int categoryId;
    int stock;
}