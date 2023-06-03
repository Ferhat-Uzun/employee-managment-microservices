package com.ferhat.employeeservice.dto;

import lombok.Data;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */
@Data
public class EmployeeDto {
    private String id;
    private String name;
    private int age;
    private String position;
}
