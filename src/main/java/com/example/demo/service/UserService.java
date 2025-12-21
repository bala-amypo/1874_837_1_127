package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
}
