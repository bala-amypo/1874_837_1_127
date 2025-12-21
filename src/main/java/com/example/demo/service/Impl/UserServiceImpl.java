package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User registerCustomer(String name, String email, String password) {
        if (repository.findByEmail(email).isPresent()) {
            throw new RuntimeException("email already exists");
        }

        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole(Role.CUSTOMER);

        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
