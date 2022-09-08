package com.coffeegit.springboot.jpamysql.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeegit.springboot.jpamysql.exceptions.AppException;
import com.coffeegit.springboot.jpamysql.model.dto.UserDto;
import com.coffeegit.springboot.jpamysql.model.dto.request.AccountRequest;
import com.coffeegit.springboot.jpamysql.service.impl.AccountRegisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/account")
@Slf4j
public class AccountController {
	
	private final AccountRegisterService registerService;

	@Autowired
	public AccountController(AccountRegisterService registerService) {
		this.registerService = registerService;
	}
	
	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerNewAccount(@Valid @RequestBody AccountRequest.SignUp signUpRequest){
		UserDto userDto = UserDto.builder()
							.firstName(signUpRequest.getFirstName())
							.lastName(signUpRequest.getLastName())
							.email(signUpRequest.getEmail())
							.role(signUpRequest.getRole())
							.build();
		try {
			registerService.registerNewAccount(userDto);
            return new ResponseEntity<>("Registration Success", HttpStatus.OK);
        } catch (AppException e) {
            log.error("Registration Exception: {}", e.getMessage());
        }
        return null;
	}
}
