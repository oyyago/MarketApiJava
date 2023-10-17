package com.market.suppliers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.suppliers.dtos.SuppliersDto;
import com.market.suppliers.services.SupplierService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @DeleteMapping(value = "/{supplierId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer supplierId) {
        String message = supplierService.deleteSupplier(supplierId);
        return  ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> updateSupplier(@PathVariable Integer supplierId,
            @RequestBody SuppliersDto suppliersDto) {
        supplierService.updateSupplier(supplierId, suppliersDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public void createSupplier(@RequestBody SuppliersDto suppliersDto) {
        supplierService.createSupplier(suppliersDto);
    }

    @GetMapping(value="/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SuppliersDto> getOneSupplier( @PathVariable Integer supplierId) {
        return supplierService.getOneSupplier(supplierId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SuppliersDto> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
}
