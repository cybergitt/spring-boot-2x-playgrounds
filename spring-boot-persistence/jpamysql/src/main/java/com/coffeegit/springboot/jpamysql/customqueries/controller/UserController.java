package com.coffeegit.springboot.jpamysql.customqueries.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeegit.springboot.jpamysql.customqueries.dto.UserDto;
import com.coffeegit.springboot.jpamysql.customqueries.entity.User;
import com.coffeegit.springboot.jpamysql.customqueries.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/custom/users")
public class UserController {
    
    private ModelMapper modelMapper;

    private UserService userService;

    // build cretae User REST API
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto.UserRequest userRequest) {
        // User newUser = new User();
        // newUser.setFirstName(userRequest.getFirstName());
        // newUser.setLastName(userRequest.getLastName());
        // newUser.setEmail(userRequest.getEmail());
        User newUser = modelMapper.map(userRequest, User.class); // convert DTO to Entity
        User savedUser = userService.createUser(newUser);
        return new ResponseEntity<>("Account " + savedUser.getFirstName() + " is already created.", HttpStatus.CREATED);
    }

    // build get user by id REST API
    // {{host}}:{{port}}/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto.UserResponse> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        // UserDto.UserResponse response = UserDto.UserResponse.builder()
        //                                 .firstName(user.getFirstName())
        //                                 .lastName(user.getLastName())
        //                                 .email(user.getEmail())
        //                                 .build();
        UserDto.UserResponse response = modelMapper.map(user, UserDto.UserResponse.class); // convert Entity to DTO
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //build get all users REST API
    // {{host}}:{{port}}/api/users
    @GetMapping
    public ResponseEntity<List<UserDto.UserResponse>> getAllUsers() {
        List<UserDto.UserResponse> responses = userService.getAllUsers().stream().map(user -> modelMapper.map(user, UserDto.UserResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    //build get all users REST API
    // {{host}}:{{port}}/api/users/active
    @GetMapping("/active")
    public ResponseEntity<List<UserDto.UserResponse>> getAllActiveUsers() {
        List<UserDto.UserResponse> responses = userService.getAllActiveUsers().stream().map(user -> modelMapper.map(user, UserDto.UserResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // {{host}}:{{port}}/api/users/1
    public ResponseEntity<UserDto.UserResponse> updateUser(@PathVariable("id") Long userId,
                                           @Valid @RequestBody UserDto.UserRequest userRequest){
        User updateUserRequest = modelMapper.map(userRequest, User.class); // convert DTO to Entity
        updateUserRequest.setId(userId);
        User updatedUser = userService.updateUser(updateUserRequest);
        UserDto.UserResponse response = modelMapper.map(updatedUser, UserDto.UserResponse.class); // convert Entity to DTO
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
