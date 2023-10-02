package com.market.suppliers.exceptions;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(String suplierId) {
        super("Suplier not found for id: " + suplierId);
    }
}