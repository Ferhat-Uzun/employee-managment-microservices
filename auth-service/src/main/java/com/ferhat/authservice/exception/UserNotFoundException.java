package com.ferhat.authservice.exception;

/**
 * @author Ferhat on 6/19/2023
 * @project employee-managment-microservices
 */

public class UserNotFoundException  extends  Exception{
    private String message;

    public UserNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
