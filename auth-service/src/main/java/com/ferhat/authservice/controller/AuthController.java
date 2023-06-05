package com.ferhat.authservice.controller;

import com.ferhat.authservice.dto.Request;
import com.ferhat.authservice.model.UserCredential;
import com.ferhat.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ferhat on 6/3/2023
 * @project employee-managment-microservices
 */

@RestController
@CrossOrigin
@RequestMapping("auth")
public class AuthController {


    private final AuthService service;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String getToken(@RequestBody Request authRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));

        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getName());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
