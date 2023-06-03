package com.ferhat.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */

@Data
@AllArgsConstructor
public class EmployeesByDepartmentDto {

    private String departmentId;
    private List<EmployeeDto> employeeList ;

}
