package com.coffeegit.springboot.jpamysql.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coffeegit.springboot.jpamysql.basic.entity.User;
import com.coffeegit.springboot.jpamysql.basic.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOneById(Long userId) {
        Optional<User> optUser = userRepository.findById(userId);
        return optUser.isPresent() ? optUser.get() : null;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User currentUser = userRepository.findById(user.getId()).get();
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(currentUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
}
