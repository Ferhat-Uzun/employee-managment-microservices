package com.ferhat.employeeservice.expection;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */
public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
