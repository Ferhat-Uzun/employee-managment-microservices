package com.ferhat.authservice.controller;

import com.ferhat.authservice.config.JwtGenerator;
import com.ferhat.authservice.exception.UserNotFoundException;
import com.ferhat.authservice.model.UserCredential;
import com.ferhat.authservice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService service;
    private final JwtGenerator jwtGenerator;

    public AuthController(AuthService service, JwtGenerator jwtGenerator) {
        this.service = service;
        this.jwtGenerator=jwtGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody UserCredential user){
        try{
            service.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserCredential user) {
        try {
                if(user.getUsername() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Username or Password is Empty");
            }
            UserCredential userData = service.getUserByNameAndPassword(user.getUsername(), user.getPassword());
            if(userData == null){
                throw new UserNotFoundException("Username or Password is Invalid");
            }
            return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
