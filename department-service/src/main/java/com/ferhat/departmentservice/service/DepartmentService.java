package com.ferhat.departmentservice.service;

import com.ferhat.departmentservice.client.EmployeeClient;
import com.ferhat.departmentservice.dto.DepartmentDto;
import com.ferhat.departmentservice.dto.EmployeesByDepartmentDto;
import com.ferhat.departmentservice.expection.DepartmentAlreadyExist;
import com.ferhat.departmentservice.expection.DepartmentNotFoundException;
import com.ferhat.departmentservice.model.Department;
import com.ferhat.departmentservice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private EmployeeClient employeeClient;
    private ModelMapper modelMapper;
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.modelMapper= modelMapper;
        this.employeeClient = employeeClient;
    }

    public Department addDepartment(Department department){

        EmployeesByDepartmentDto employeesByDepartmentDto =
                new EmployeesByDepartmentDto(department.getId(),
                        department.getEmployees_id()
                        .stream()
                        .map(employee -> employeeClient.getEmployeeById(employee).getBody())
                        .collect(Collectors.toList()));

        if (departmentRepository.existsByName(department.getName())) {
            throw new DepartmentAlreadyExist("This department already exist");
        }

        return departmentRepository.save(department);
    }

    public DepartmentDto findDepartmentById(String id){
        return departmentRepository.findById(id)
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .orElseThrow(
                () -> new DepartmentNotFoundException("Department not found by id") );
    }

    public List<DepartmentDto> getAllDepartments(){
        return departmentRepository.findAll()
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public EmployeesByDepartmentDto getAllEmployeesByDepartment(String department_id){
        Department department = departmentRepository.findById(department_id)
                .orElseThrow( () -> new DepartmentNotFoundException("Department not found"));

        return new EmployeesByDepartmentDto(department.getId(),
                department.getEmployees_id()
                .stream()
                .map(employee -> employeeClient.getEmployeeById(employee).getBody())
                .collect(Collectors.toList()));
    }

    public void deleteDepartmentById(String id) {
        departmentRepository.deleteById(id);
    }
}
