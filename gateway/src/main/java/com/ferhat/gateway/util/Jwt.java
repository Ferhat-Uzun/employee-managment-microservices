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

    @Value("${jwt.secret}")
    private String secret;

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey())
                .build().parseClaimsJws(token);
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
