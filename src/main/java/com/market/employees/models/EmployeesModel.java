package com.market.employees.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Table(name = "EMPLOYEES")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    private String name;
    private String phone;
    private String email;
    private String position;
    @Column(name = "hourly_rate")
    private String hourlyRate;
    @Column(name = "hire_date")
    private String hireDate;
}
