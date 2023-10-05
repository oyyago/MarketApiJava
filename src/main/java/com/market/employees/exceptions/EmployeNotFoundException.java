package com.market.employees.exceptions;

public class EmployeNotFoundException extends RuntimeException {
    public EmployeNotFoundException(Integer employee_id) {
        super("Employee not found for id: " + employee_id);
    }
}