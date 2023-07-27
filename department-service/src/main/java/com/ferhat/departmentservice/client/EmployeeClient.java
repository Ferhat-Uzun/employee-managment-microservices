package com.ferhat.departmentservice.client;

import com.ferhat.departmentservice.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "employee-service", path = "/employee")
public interface EmployeeClient{

    @GetMapping("{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String id);

}
