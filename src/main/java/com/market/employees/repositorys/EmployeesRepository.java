package com.market.employees.repositorys;

import com.market.employees.models.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesModel, Integer> {
}
