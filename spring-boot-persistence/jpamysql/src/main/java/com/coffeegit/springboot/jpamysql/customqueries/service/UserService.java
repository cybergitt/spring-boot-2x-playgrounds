package com.coffeegit.springboot.jpamysql.customqueries.service;

import java.util.List;

import com.coffeegit.springboot.jpamysql.customqueries.entity.User;

public interface UserService {
    
    User createUser(User user);
    
    User getUserById(Long userId);
    
    List<User> getAllUsers();

    List<User> getAllActiveUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
