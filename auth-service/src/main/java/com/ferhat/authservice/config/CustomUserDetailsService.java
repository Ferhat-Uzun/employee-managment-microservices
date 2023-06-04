package com.ferhat.authservice.config;

import com.ferhat.authservice.model.UserCredential;
import com.ferhat.authservice.repository.UserCredentialRepository;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserCredentialRepository repository;
    public CustomUserDetailsService(UserCredentialRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserCredential> credential = repository.findByName(name);
        return credential.map(CustomUserDetails::new).orElseThrow(
                () -> new UsernameNotFoundException("User not found with :" + name));
    }
}
