package com.example.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtParser;
import org.springframework.stereotype.Component;

import java.util.Date;
import com.example.demo.entity.Role;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "mySuperSecretKey12345678901234567890123456789012";

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .subject(username)
                .claim("role", role) // ✅ Store role as String
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(getSigningKey())
                .compact();
    }

    public Role extractRole(String token) {
        JwtParser parser = Jwts.parser()
                .verifyWith(getSigningKey())
                .build();

        Claims claims = parser.parseSignedClaims(token).getPayload();
        return Role.valueOf(claims.get("role", String.class)); // ✅ Convert to Enum
    }
}
