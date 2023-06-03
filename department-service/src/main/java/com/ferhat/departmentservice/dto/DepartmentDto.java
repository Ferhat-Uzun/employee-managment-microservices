package com.ferhat.departmentservice.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */
@Data
public class DepartmentDto {
    private String departmentId;
    private String name;
    private List<String> employees_id ;
}
