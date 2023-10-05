package com.market.employees.services;

import com.market.employees.dtos.EmployeesDto;
import com.market.employees.exceptions.EmployeNotFoundException;
import com.market.employees.models.EmployeesModel;
import com.market.employees.repositorys.EmployeesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    private final EmployeesRepository employeesRepository;
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
}
    public ResponseEntity<String> deleteEmployer(Integer employerId) {
        Optional<EmployeesModel> EmOptional = employeesRepository.findById(employerId);
        if (EmOptional.isPresent()) {
            EmployeesModel employeesModel= EmOptional.get();
            employeesRepository.delete(employeesModel);
            return ResponseEntity.ok("Employeer deletd with sucess.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employeer not found.");
        }
    }
    public void updateEmployeer(Integer employerId, EmployeesDto employeesDto) {
        Optional<EmployeesModel> optionalEmployeer = employeesRepository.findById(employerId);
        if (optionalEmployeer.isPresent()) {
            EmployeesModel employeesModel = optionalEmployeer.get();
            employeesModel = EmployeesModel.builder( ).
                    employee_id(employeesModel.getEmployee_id())
                    .name(employeesDto.getName())
                    .phone(employeesDto.getPhone())
                    .email(employeesDto.getEmail())
                    .position(employeesDto.getPosition())
                    .hourly_rate(employeesDto.getHourly_rate())
                    .hire_date(employeesDto.getHire_date())
                    .build();
            employeesRepository.save(employeesModel);
        }
    }

    public void createEmployeer(EmployeesDto employeesDto){
        EmployeesModel employeesModel = EmployeesModel.builder().
                employee_id(employeesDto.getEmployee_id())
                .name(employeesDto.getName())
                .phone(employeesDto.getPhone())
                .email(employeesDto.getEmail())
                .position(employeesDto.getPosition())
                .hourly_rate(employeesDto.getHourly_rate())
                .hire_date(employeesDto.getHire_date())
                .build();
        employeesRepository.save(employeesModel);
    }

    public List<EmployeesDto> getOneEmployeer(Integer employeerId) {
        Optional<EmployeesModel> employeer = employeesRepository.findById(employeerId);
        if(employeer.isEmpty()){
            throw new EmployeNotFoundException(employeerId);
        }
        return employeer.stream().map(this::mapToEmployeesResponse).toList();
    }
    public List<EmployeesDto> getAllEmployees() {
        List<EmployeesModel> employees = employeesRepository.findAll();
        return employees.stream().map(this::mapToEmployeesResponse).toList();
    }

    public EmployeesDto mapToEmployeesResponse(EmployeesModel employeer){
        return EmployeesDto.builder().
                employee_id(employeer.getEmployee_id())
                .name(employeer.getName())
                .phone(employeer.getPhone())
                .email(employeer.getEmail())
                .position(employeer.getPosition())
                .hourly_rate(employeer.getHourly_rate())
                .hire_date(employeer.getHire_date())
                .build();
    }
}