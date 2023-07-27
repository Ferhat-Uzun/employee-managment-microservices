package com.ferhat.employeeservice.controller;

import com.ferhat.employeeservice.dto.EmployeeDto;
import com.ferhat.employeeservice.model.Employee;
import com.ferhat.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id){
        return  ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping
    ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteEmployeeById(@PathVariable String id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}
