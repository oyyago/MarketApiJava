    package com.market.products.controller;

    import com.market.products.dtos.ProductRequest;
    import com.market.products.dtos.ProductsResponse;
    import com.market.products.services.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
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

        @DeleteMapping(value = "/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
            productService.deleteProduct(productId);
            return ResponseEntity.noContent().build();
        }
            @PutMapping(value = "/{productId}",produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE )
            public ResponseEntity<Void> updateProduct(@PathVariable Integer productId, @RequestBody ProductRequest productRequest) {
                productService.updateProduct(productId, productRequest);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE )
        @ResponseStatus(HttpStatus.CREATED)
        public void createProduct(@RequestBody ProductRequest productRequest){
            productService.createProduct(productRequest);
        }
        @GetMapping(value = "/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
        public List<ProductsResponse> getOneProduct(@PathVariable Integer productId) {
            return productService.getOneProduct(productId);
        }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public List<ProductsResponse> getAllProducts(){
            return productService.getAllProducts();
        }
    }
