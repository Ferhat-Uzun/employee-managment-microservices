package com.ferhat.authservice.service;

import com.ferhat.authservice.model.UserCredential;
import com.ferhat.authservice.repository.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Ferhat on 6/3/2023
 * @project employee-managment-microservices
 */
@Service
public class AuthService {

    private UserCredentialRepository userCredentialRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthService(UserCredentialRepository userCredentialRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userCredentialRepository = userCredentialRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        userCredentialRepository.save(credential);
        return "User added to system";
    }

    public String generateToken(String name) {
        return jwtService.generateToken(name);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
