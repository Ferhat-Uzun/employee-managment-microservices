package com.ferhat.authservice.config;

import com.ferhat.authservice.model.UserCredential;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtGenerator {

    private String secret = "0e8493e41b79bf587eefc2459d4cc95f60052e50a2c7b5177ac81867d6cf4b827bfabe92";


    public Map<String, String> generateToken(UserCredential user) {
        String jwtToken="";
        jwtToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, secret).compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", jwtToken);
        return jwtTokenGen;
    }

}
