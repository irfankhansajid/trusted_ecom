package com.example.escrow.e_com.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationTime = 1000*60*60;



}
