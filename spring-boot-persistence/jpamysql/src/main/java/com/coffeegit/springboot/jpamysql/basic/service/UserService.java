package com.coffeegit.springboot.jpamysql.basic.service;

import java.util.List;
import com.coffeegit.springboot.jpamysql.basic.entity.User;

public interface UserService {

    User createUser(User user);
    
    User findOneById(Long userId);
    
    List<User> findAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
