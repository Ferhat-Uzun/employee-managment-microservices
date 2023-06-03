package com.ferhat.employeeservice.repository;

import com.ferhat.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */

public interface EmployeeRepository  extends JpaRepository<Employee, String> {
}
