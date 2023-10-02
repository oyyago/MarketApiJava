    package com.market.suppliers.controller;


    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

import com.market.suppliers.dtos.SuppliersDto;
import com.market.suppliers.services.SupplierService;

import java.util.List;

    @RestController
    @RequestMapping("/suppliers")
    public class SupplierController {
        private final SupplierService supplierService;

        @Autowired
        public  SupplierController(SupplierService supplierService){
            this.supplierService = supplierService;
        }


        @DeleteMapping("/{supplierId}")
        public ResponseEntity<String> deleteSupplier(@PathVariable Integer supplierId) {
            ResponseEntity<String> response = supplierService.deleteSupplier(supplierId);
            return response;
        }

        @PutMapping("/{supplierId}")
            public ResponseEntity<Void> updateSupplier(@PathVariable Integer supplierId, @RequestBody SuppliersDto suppliersDto) {
                supplierService.updateSupplier(supplierId, suppliersDto);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createSupplier(@RequestBody SuppliersDto suppliersDto){
            supplierService.createSupplier(suppliersDto);
        }
        @GetMapping("/{supplierId}")
        public List<SuppliersDto> getOneSupplier(@PathVariable Integer supplierId) {
            return supplierService.getOneSupplier(supplierId);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<SuppliersDto> getAllSuppliers(){
            return supplierService.getAllSuppliers();
        }
    }
