package com.ferhat.departmentservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {
    private String departmentId;
    private String name;
    private List<String> employees_id ;
}
