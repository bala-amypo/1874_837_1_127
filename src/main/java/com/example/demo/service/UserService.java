package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User findById(Long id);

    User findByUsername(String username);
}
