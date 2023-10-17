package com.market.categories.productController;

import java.util.List;
import java.util.Optional;
import com.market.categories.models.CategoriesModel;
import com.market.categories.productRepository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriesModel>> getAllCategories(){
		List<CategoriesModel> categoriesList = categoriesRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(categoriesList);
	}

    @GetMapping(value = "{categoryId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOneCategory(@PathVariable(value = "categoryId") Integer categoryId) {
        Optional<CategoriesModel> category = categoriesRepository.findById(categoryId);
        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(category.get());
    }
}
