package com.market.employees.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {
    @NotNull Integer employee_id;
    @NotNull String name;
    @NotNull String phone;
    @NotNull String email;
    @NotNull String position;
    @NotNull String hourly_rate;
    @NotNull String hire_date;
}