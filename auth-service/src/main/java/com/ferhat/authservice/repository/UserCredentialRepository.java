package com.ferhat.authservice.repository;

import com.ferhat.authservice.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential,String> {

    UserCredential findByUsernameAndPassword(String username, String password);
}
