package com.market.categories.productRepository;

import com.market.categories.models.CategoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesModel, Integer>{
}
