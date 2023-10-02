package com.market.suppliers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Table(name = "SUPPLIERS")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private String supplier_id;
    private String name;
    private String phone;
    private String email;
}
