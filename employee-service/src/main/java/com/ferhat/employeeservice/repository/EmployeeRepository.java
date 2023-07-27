package com.ferhat.employeeservice.repository;

import com.ferhat.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository  extends JpaRepository<Employee, String> {
}
