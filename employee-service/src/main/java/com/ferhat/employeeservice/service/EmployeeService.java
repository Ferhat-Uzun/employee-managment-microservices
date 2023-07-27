package com.ferhat.employeeservice.service;

import com.ferhat.employeeservice.dto.EmployeeDto;
import com.ferhat.employeeservice.expection.EmployeeNotFoundException;
import com.ferhat.employeeservice.model.Employee;
import com.ferhat.employeeservice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper= modelMapper;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public EmployeeDto findEmployeeById(String id){
        return employeeRepository.findById(id)
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found by id") );
    }

    public List<EmployeeDto> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public void deleteEmployeeById(String id){
        employeeRepository.deleteById(id);
    }
}
