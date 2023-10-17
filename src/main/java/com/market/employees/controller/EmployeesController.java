    package com.market.employees.controller;


    import com.market.employees.dtos.EmployeesDto;
    import com.market.employees.services.EmployeesService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/employees")
    public class EmployeesController {
        private final EmployeesService employeesService;

        @Autowired
        public EmployeesController(EmployeesService employeesService){
            this.employeesService = employeesService;
        }

        @DeleteMapping(value = "/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
            employeesService.deleteEmployer(employeeId);
            return ResponseEntity.noContent().build();
        }

        @PutMapping(value = "/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE )
            public ResponseEntity<Void> updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeesDto employeesDto) {
                employeesService.updateEmployeer(employeeId, employeesDto);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE )
        @ResponseStatus(HttpStatus.CREATED)
        public void createEmployeer(@RequestBody EmployeesDto employeesDto){
            employeesService.createEmployeer(employeesDto);
        }
        @GetMapping(value = "/{employeerId}",produces = MediaType.APPLICATION_JSON_VALUE)
        public List<EmployeesDto> getOneEmployeer(@PathVariable Integer employeerId) {
            return employeesService.getOneEmployeer(employeerId);
        }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public List<EmployeesDto> getAllEmployees(){
            return employeesService.getAllEmployees();
        }
    }
