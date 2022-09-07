package com.coffeegit.springboot.jpamysql.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;

import com.coffeegit.springboot.jpamysql.exceptions.AppException;
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
	public Optional<User> getUserByEmail(String email) throws AppException {
		Optional<User> retrievedUsers = userRepository.findByEmail(email);
		return Optional.ofNullable(retrievedUsers).orElseThrow(() -> new AppException(String.format("The user having email %s was not found", email)));
	}

	@Override
	public Optional<User> getUserByUsername(String username) throws AppException {
		Optional<User> retrievedUsers = userRepository.findByUsername(username);
		return Optional.ofNullable(retrievedUsers).orElseThrow(() -> new AppException(String.format("The user having username %s was not found", username)));
	}

	@Override
	public Optional<User> getUserById(UUID id) throws AppException {
		Optional<User> retrievedUsers = userRepository.findById(id);
		return Optional.ofNullable(retrievedUsers).orElseThrow(() -> new AppException(String.format("The user having data %s was not found", id)));
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
	public User updateUser(UUID id, UserDto userDto) {
		User user = null;
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.isPresent()) {
			user = optUser.get();
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			return userRepository.save(user);
		}
		return user;
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

	@Override
	public String generateUsername(UserDto userDto) {
		return userDto.getEmail().substring(0, userDto.getEmail().indexOf('@')).toLowerCase();
	}

}
