package com.ferhat.departmentservice.expection;

public class DepartmentAlreadyExist extends RuntimeException{
    public DepartmentAlreadyExist(String message) {
        super(message);
    }
}
