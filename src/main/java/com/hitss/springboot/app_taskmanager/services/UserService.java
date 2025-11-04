package com.hitss.springboot.app_taskmanager.services;

import java.util.List;

import com.hitss.springboot.app_taskmanager.models.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
