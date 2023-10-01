package com.market.products.services;

import com.market.products.dtos.ProductRequest;
import com.market.products.dtos.ProductsResponse;
import com.market.products.models.ProductModel;
import com.market.products.repositorys.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/products")
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void updateProduct(String productId, ProductRequest productRequest) {
        Optional<ProductModel> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            ProductModel productModel = optionalProduct.get();
            productModel = ProductModel.builder().
                    product_id(productModel.getProduct_id())
                    .product_name(productRequest.getProduct_name())
                    .unit_price(productRequest.getUnit_price())
                    .supplier_id(productRequest.getSupplier_id())
                    .category_id(productRequest.getCategory_id())
                    .stock(productRequest.getStock())
                    .build();
            productRepository.save(productModel);
        }
    }


    public void createProduct(ProductRequest productRequest){
        ProductModel productModel = ProductModel.builder().
                product_id(productRequest.getProduct_id()).
                product_name(productRequest.getProduct_name()).
                unit_price(productRequest.getUnit_price()).
                supplier_id(productRequest.getSupplier_id()).
                category_id(productRequest.getCategory_id()).
                stock(productRequest.getStock()).
                build();
        productRepository.save(productModel);
    }

    public List<ProductsResponse> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductsResponse mapToProductResponse(ProductModel product){
        return ProductsResponse.builder().
                productId(product.getProduct_id()).
                product_name(product.getProduct_name()).
                unit_price(product.getUnit_price()).
                supplier_id(product.getSupplier_id()).
                category_id(product.getCategory_id()).
                stock(product.getStock()).
                build();
    }
}