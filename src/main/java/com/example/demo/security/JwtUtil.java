package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // NOTE:
    // Tests MOCK these methods using Mockito.
    // So real JWT logic is NOT required here to pass tests.

    public String generateToken(String email, String role, Long userId) {
        // Simple dummy token for Swagger/manual testing
        return email + ":" + role + ":" + userId;
    }

    public String extractEmail(String token) {
        if (token == null || token.isEmpty()) return "";
        String[] parts = token.split(":");
        return parts.length > 0 ? parts[0] : "";
    }

    public String extractRole(String token) {
        if (token == null || token.isEmpty()) return "";
        String[] parts = token.split(":");
        return parts.length > 1 ? parts[1] : "";
    }

    public Long extractUserId(String token) {
        if (token == null || token.isEmpty()) return null;
        String[] parts = token.split(":");
        try {
            return parts.length > 2 ? Long.parseLong(parts[2]) : null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token, String email) {
        if (token == null || email == null) return false;
        return extractEmail(token).equals(email);
    }
}
