package com.market.suppliers.repositorys;

import com.market.suppliers.models.SuppliersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SuppliersModel, String> {
}
