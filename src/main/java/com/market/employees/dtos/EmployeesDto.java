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
    @NotNull Integer employeeId;
    @NotNull String name;
    @NotNull String phone;
    @NotNull String email;
    @NotNull String position;
    @NotNull String hourlyRate;
    @NotNull String hireDate;
}