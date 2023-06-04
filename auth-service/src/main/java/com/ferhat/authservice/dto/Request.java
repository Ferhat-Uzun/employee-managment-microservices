package com.ferhat.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ferhat on 6/3/2023
 * @project employee-managment-microservices
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private String name;
    private String password;
}
