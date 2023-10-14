package com.market.products.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Table(name = "PRODUCTS")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "category_id")
    private int categoryId;

    private int stock;
}

