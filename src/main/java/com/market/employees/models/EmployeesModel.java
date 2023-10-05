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
    private Integer employee_id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private String hourly_rate;
    private String hire_date;
}
