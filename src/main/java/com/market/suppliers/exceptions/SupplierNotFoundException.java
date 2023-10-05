package com.market.suppliers.exceptions;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(Integer suplierId) {
        super("Suplier not found for id: " + suplierId);
    }
}