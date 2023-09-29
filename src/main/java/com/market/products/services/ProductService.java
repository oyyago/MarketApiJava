package com.market.products.services;

import com.market.products.dtos.ProductsResponse;
import com.market.products.models.ProductModel;
import com.market.products.repositorys.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
@RequestMapping("/products")
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductsResponse> getAllProducts(){
        List<ProductModel> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductsResponse mapToProductResponse(ProductModel product){
        return new ProductsResponse.Builder().
                productId(product.getProduct_id()).
                product_name(product.getProduct_name()).
                unite_price(product.getUnite_price()).
                supplier_id(product.getSupplier_id()).
                category_id(product.getCategory_id()).
                stock(product.getStock()).
                build();
    }

}