package com.coffeegit.springboot.jpamysql.service;

import java.util.Collection;
import java.util.List;

import com.coffeegit.springboot.jpamysql.model.dto.RoleDto;
import com.coffeegit.springboot.jpamysql.model.dto.UserDto;
import com.coffeegit.springboot.jpamysql.model.entity.Group;
import com.coffeegit.springboot.jpamysql.model.entity.Role;
import com.coffeegit.springboot.jpamysql.model.entity.User;

public interface UserService {

	void registerNewAccount(final UserDto user);
	
	void generateUsername(UserDto userDto, User user);

    void generatePassword(UserDto userDto, User user);

    User saveUser(User user);

    User saveUserAndFlush(User user);

    User updateUser(Long id, UserDto dto);

    void removeUserById(Long id);

    List<User> getAllUser();

    User getUserByEmail(String email);

    User getUserById(Long id);

    boolean isEmailAlreadyExist(String email);

    User addUserRole(Long id, RoleDto roleDto);

    List<String> getUserGroups(Collection<Group> groups);

    List<String> getUserGroupsSorted(Collection<Group> groups);

    List<String> getUserRoles(Collection<Role> roles);

    List<String> getUserRolesSorted(Collection<Role> roles);

}
