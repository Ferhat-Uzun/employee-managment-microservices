package com.ferhat.authservice.repository;

import com.ferhat.authservice.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Ferhat on 6/3/2023
 * @project employee-managment-microservices
 */
public interface UserCredentialRepository extends JpaRepository<UserCredential,String> {

    UserCredential findByUsernameAndPassword(String username, String password);
}
