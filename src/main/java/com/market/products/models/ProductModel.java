package com.market.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "PRODUCTS")
public class ProductModel implements Serializable {

    @Id
    private String Product_id;
    private String product_name;
    private String unite_price;
    private int supplier_id;
    private int category_id;
    private int stock;


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

    public String getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(String product_id) {
        Product_id = product_id;
    }
}
