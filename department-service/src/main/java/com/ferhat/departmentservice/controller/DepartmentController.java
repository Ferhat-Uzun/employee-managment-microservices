package com.ferhat.departmentservice.controller;
//com.lenora.core
import com.ferhat.departmentservice.dto.DepartmentDto;
import com.ferhat.departmentservice.dto.EmployeesByDepartmentDto;
import com.ferhat.departmentservice.model.Department;
import com.ferhat.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */

@RestController
@RequestMapping("department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    ResponseEntity<Void> addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    ResponseEntity<DepartmentDto> findDepartmentById(@PathVariable String id){
        return ResponseEntity.ok(departmentService.findDepartmentById(id));
    }

    @GetMapping
    ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("{id}/employee")
    ResponseEntity<EmployeesByDepartmentDto> getAllEmployeesByDepartment(@PathVariable String id){
        return ResponseEntity.ok(departmentService
                .getAllEmployeesByDepartment(id));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteDepartment(@PathVariable String id){
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok().build();
    }

}