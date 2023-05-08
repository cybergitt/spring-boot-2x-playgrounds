package com.coffeegit.springboot.jpamysql.basic.service;

import java.util.List;
import com.coffeegit.springboot.jpamysql.basic.entity.User;

public interface UserService {

    User createUser(User user);
    
    User getUserById(Long userId);
    
    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
