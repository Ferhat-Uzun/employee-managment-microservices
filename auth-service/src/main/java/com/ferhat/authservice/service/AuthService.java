package com.ferhat.authservice.service;

import com.ferhat.authservice.config.JwtGenerator;
import com.ferhat.authservice.exception.UserNotFoundException;
import com.ferhat.authservice.model.UserCredential;
import com.ferhat.authservice.repository.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserCredentialRepository userCredentialRepository;

    public AuthService(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    public void saveUser(UserCredential user) {
        userCredentialRepository.save(user);
    }

    public UserCredential getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
        UserCredential user = userCredentialRepository.findByUsernameAndPassword(name, password);
        if(user == null){
            throw new UserNotFoundException("Invalid id and password");
        }
        return user;
    }
}
