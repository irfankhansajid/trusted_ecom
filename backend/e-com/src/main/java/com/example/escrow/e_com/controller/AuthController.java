package com.example.escrow.e_com.controller;

import com.example.escrow.e_com.dto.AuthRequest;
import com.example.escrow.e_com.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {

        String token = authService.login(request.getEmail(), request.getPassword());

        return ResponseEntity.ok(Map.of("token", token));
    }
}
