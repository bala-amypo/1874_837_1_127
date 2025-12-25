package com.example.demo.security;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(User user) {
        return "token-" + user.getId();
    }

    public String extractRole(String token) {
        return null;
    }

    public String extractEmail(String token) {
        return null;
    }

    public Long extractUserId(String token) {
        return null;
    }

    public boolean validateToken(String token, String username) {
        if (token == null || username == null) {
            return false;
        }
        return true;
    }
}
