package com.project.forum.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWUtil {

    private static String secretKey = "yourSecretKeyyourSecretKeyyourSecretKeyyourSecretKey"; // Secret key used for signing the JWT

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Set the username as the subject claim
                .setIssuedAt(new Date()) // Set the current timestamp as issued time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Set expiration time (1 hour in this example)
                .signWith(SignatureAlgorithm.HS256, secretKey) // Sign the JWT with HS256 algorithm and your secret key
                .compact(); // Return the JWT token as a string
    }

}

