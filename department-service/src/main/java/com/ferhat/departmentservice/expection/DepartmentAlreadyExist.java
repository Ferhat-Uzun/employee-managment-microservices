package com.ferhat.departmentservice.expection;

/**
 * @author Ferhat on 6/3/2023
 * @project employee-managment-microservices
 */
public class DepartmentAlreadyExist extends RuntimeException{
    public DepartmentAlreadyExist(String message) {
        super(message);
    }
}
