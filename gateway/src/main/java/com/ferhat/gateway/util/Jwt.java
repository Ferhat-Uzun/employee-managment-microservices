package com.ferhat.gateway.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Ferhat on 6/3/2023
 * @project employee-managment-microservices
 */

@Component
public class Jwt {

    private String secret = "0e8493e41b79bf587eefc2459d4cc95f60052e50a2c7b5177ac81867d6cf4b827bfabe92";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey())
                .build().parseClaimsJws(token);
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
