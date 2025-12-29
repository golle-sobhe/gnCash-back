package com.fh.gncash.controller;

import com.fh.gncash.dto.AuthResponse;
import com.fh.gncash.service.JWTService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JWTService jwtService;

    public AuthController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    /**
     * Login endpoint using HTTP Basic Authentication.
     * Send request with header: Authorization: Basic base64(phoneNumber:password)
     * Returns a JWT token for subsequent requests.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("Authentication required");
        }
        return ResponseEntity.ok(new AuthResponse(jwtService.generateToken(userDetails)));
    }
}
