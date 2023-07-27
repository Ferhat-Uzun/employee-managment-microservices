package com.ferhat.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class EmployeeDto {
    private String id;
    private String name;
    private int age;
    private String position;
}
