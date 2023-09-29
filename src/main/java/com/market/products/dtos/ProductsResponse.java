package com.market.products.dtos;

public class ProductsResponse{
    String productId;
    String product_name;
    String unite_price;
    int supplier_id;
    int category_id;
    int stock;
    private ProductsResponse(Builder builder) {
        this.productId = builder.productId;
        this.product_name = builder.product_name;
        this.unite_price = builder.unite_price;
        this.supplier_id = builder.supplier_id;
        this.category_id = builder.category_id;
        this.stock = builder.stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getUnite_price() {
        return unite_price;
    }

    public void setUnite_price(String unite_price) {
        this.unite_price = unite_price;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static class Builder {
        private String productId;
        private String product_name;
        private String unite_price;
        private int supplier_id;
        private int category_id;
        private int stock;

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder product_name(String product_name) {
            this.product_name = product_name;
            return this;
        }

        public Builder unite_price(String unite_price) {
            this.unite_price = unite_price;
            return this;
        }

        public Builder supplier_id(int supplier_id) {
            this.supplier_id = supplier_id;
            return this;
        }

        public Builder category_id(int category_id) {
            this.category_id = category_id;
            return this;
        }

        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public ProductsResponse build() {
            return new ProductsResponse(this);
        }
    }
}
