package com.market.products.controller;

import com.market.products.dtos.ProductRequest;
import com.market.products.dtos.ProductsResponse;
import com.market.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public  ProductController(ProductService productService){
        this.productService = productService;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable String productId, @RequestBody ProductRequest productRequest) {
            productService.updateProduct(productId, productRequest);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductsResponse> getAllProducts(){
        return productService.getAllProducts();
    }


}
