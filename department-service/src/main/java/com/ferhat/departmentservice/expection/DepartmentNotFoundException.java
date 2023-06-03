package com.ferhat.departmentservice.expection;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-managment-microservices
 */
public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
