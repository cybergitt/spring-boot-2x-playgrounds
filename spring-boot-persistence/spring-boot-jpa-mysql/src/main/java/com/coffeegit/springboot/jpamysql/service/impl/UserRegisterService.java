package com.coffeegit.springboot.jpamysql.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;

import com.coffeegit.springboot.jpamysql.model.dto.UserDto;
import com.coffeegit.springboot.jpamysql.model.entity.User;
import com.coffeegit.springboot.jpamysql.repository.RoleRepository;
import com.coffeegit.springboot.jpamysql.repository.UserRepository;
import com.coffeegit.springboot.jpamysql.service.UserService;

public class UserRegisterService implements UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserRegisterService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public List<User> getAllUsers() {
//		var sortedUsers = userRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserByEmail(String email) throws Exception {
		Optional<User> retrievedUsers = userRepository.findByEmail(email);
		return Optional.ofNullable(retrievedUsers).orElseThrow(() -> new Exception(String.format("The user having email %s was not found", email)));
	}

	@Override
	public Optional<User> getUserByUsername(String username) throws Exception {
		Optional<User> retrievedUsers = userRepository.findByUsername(username);
		return Optional.ofNullable(retrievedUsers).orElseThrow(() -> new Exception(String.format("The user having username %s was not found", username)));
	}

	@Override
	public Optional<User> getUserById(UUID id) throws Exception {
		Optional<User> retrievedUsers = userRepository.findById(id);
		return Optional.ofNullable(retrievedUsers).orElseThrow(() -> new Exception(String.format("The user having data %s was not found", id)));
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User saveUserAndFlush(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User updateUser(UUID id, UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserByUsername(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmailAlreadyExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUsernameAlreadyExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
