package com.market.products.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY para colunas serial
    @Column(name = "product_id")
    private String product_id;
    private String product_name;
    @NotNull(message = "unit_price is required")
    private Float unit_price;
    private int supplier_id;
    private int category_id;
    private int stock;
}
