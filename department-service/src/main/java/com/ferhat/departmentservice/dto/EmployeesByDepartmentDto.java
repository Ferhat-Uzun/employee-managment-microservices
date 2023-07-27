package com.ferhat.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class EmployeesByDepartmentDto {

    private String departmentId;
    private List<EmployeeDto> employeeList ;

}
