package com.market.suppliers.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.suppliers.dtos.SuppliersDto;
import com.market.suppliers.exceptions.SupplierNotFoundException;
import com.market.suppliers.models.SuppliersModel;
import com.market.suppliers.repositorys.SupplierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequestMapping("/suppliers")
public class SupplierService {
    private final SupplierRepository supplierRepository;
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public String deleteSupplier(Integer supplierId) {
        Optional<SuppliersModel> suOptional = supplierRepository.findById(supplierId);
        if (suOptional.isPresent()) {
            SuppliersModel suppliersModel = suOptional.get();
            supplierRepository.delete(suppliersModel);
            return "Supplier deleted with success.";
        } else {
            return "Supplier not found.";
        }
    }


    public void updateSupplier(Integer supplierId, SuppliersDto suppliersDto) {
        Optional<SuppliersModel> optionalSupplier = supplierRepository.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            SuppliersModel suppliersModel = optionalSupplier.get();
            suppliersModel = SuppliersModel.builder( ).
                    supplierId(suppliersModel.getSupplierId())
                    .name(suppliersDto.getName())
                    .phone(suppliersDto.getPhone())
                    .email(suppliersDto.getEmail())
                    .build();
            supplierRepository.save(suppliersModel);
        }
    }

    public void createSupplier(SuppliersDto suppliersDto){
        SuppliersModel suppliersModel = SuppliersModel.builder().
                supplierId(suppliersDto.getSupplierId()).
                name(suppliersDto.getName()).
                phone(suppliersDto.getPhone()).
                email(suppliersDto.getEmail()).
                build();
        supplierRepository.save(suppliersModel);
    }

    public List<SuppliersDto> getOneSupplier(Integer supplierId) {
        Optional<SuppliersModel> supplier = supplierRepository.findById(supplierId);
        if(supplier.isEmpty()){
            throw new SupplierNotFoundException(supplierId);
        }
        return supplier.stream().map(this::mapToSuppliersResponse).toList();
    }

    public List<SuppliersDto> getAllSuppliers() {
        List<SuppliersModel> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(this::mapToSuppliersResponse).toList();
    }

    public SuppliersDto mapToSuppliersResponse(SuppliersModel supplier){
        return SuppliersDto.builder().
                supplierId(supplier.getSupplierId()).
                name(supplier.getName()).
                phone(supplier.getPhone()).
                email(supplier.getEmail()).
                build();
    }
}