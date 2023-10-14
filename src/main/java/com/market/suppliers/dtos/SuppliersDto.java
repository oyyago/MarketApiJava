package com.market.suppliers.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersDto {
    @NotNull Integer supplierId;
    @NotNull String name;
    @NotNull String phone;
    @NotNull String email;
}