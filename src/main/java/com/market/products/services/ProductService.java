package com.market.products.services;

import com.market.products.exceptions.ProductNotFoundException;
import com.market.products.dtos.ProductRequest;
import com.market.products.dtos.ProductsResponse;
import com.market.products.models.ProductModel;
import com.market.products.repositorys.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ResponseEntity<String> deleteProduct(Integer productId) {
        Optional<ProductModel> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            ProductModel productModel = productOptional.get();
            productRepository.delete(productModel);
            return ResponseEntity.ok("Product deletd with sucess.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
    }
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        Optional<ProductModel> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            ProductModel productModel = optionalProduct.get();
            productModel = ProductModel.builder( ).
                    productId(productModel.getProductId())
                    .productName(productRequest.getProductName())
                    .unitPrice(productRequest.getUnitPrice())
                    .supplierId(productRequest.getSupplierId())
                    .categoryId(productRequest.getCategoryId())
                    .stock(productRequest.getStock())
                    .build();
            productRepository.save(productModel);
        }
    }

    public void createProduct(ProductRequest productRequest){
        ProductModel productModel = ProductModel.builder().
                productId(productRequest.getProductId()).
                productName(productRequest.getProductName()).
                unitPrice(productRequest.getUnitPrice()).
                supplierId(productRequest.getSupplierId()).
                categoryId(productRequest.getCategoryId()).
                stock(productRequest.getStock()).
                build();
        productRepository.save(productModel);
    }

    public List<ProductsResponse> mapToProductResponses(List<ProductModel> products) {
        return products.stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }
    public List<ProductsResponse> getOneProduct(Integer productId) {
        Optional<ProductModel> product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new ProductNotFoundException(productId);
        }
        return product.stream().map(this::mapToProductResponse).toList();
    }

    public List<ProductsResponse> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    public ProductsResponse mapToProductResponse(ProductModel product){
        return ProductsResponse.builder().
                productId(product.getProductId()).
                productName(product.getProductName()).
                unitPrice(product.getUnitPrice()).
                supplierId(product.getSupplierId()).
                categoryId(product.getCategoryId()).
                stock(product.getStock()).
                build();
    }
}