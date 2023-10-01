package com.market.products.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String productId) {
        super("Product not found for id: " + productId);
    }
}

