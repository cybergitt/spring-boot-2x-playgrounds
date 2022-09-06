package com.coffeegit.springboot.jpamysql.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.coffeegit.springboot.jpamysql.model.dto.UserDto;
import com.coffeegit.springboot.jpamysql.model.entity.User;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserByEmail(String email) throws Exception;
    
    Optional<User> getUserByUsername(String username) throws Exception;

    Optional<User> getUserById(UUID id) throws Exception;

    User saveUser(User user);

    User saveUserAndFlush(User user);

    User updateUser(UUID id, UserDto dto);

    void deleteUserById(UUID id);
    
    void deleteUserByUsername(String username);

    boolean isEmailAlreadyExist(String email);
    
    boolean isUsernameAlreadyExist(String username);

}
