package com.bits.comicreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.comicreader.dto.Credentials;
import com.bits.comicreader.exception.InvalidCredentialsException;
import com.bits.comicreader.exception.UserAlreadyRegisteredException;
import com.bits.comicreader.model.User;
import com.bits.comicreader.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1.0/comics")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/health")
	public ResponseEntity<String> healthCheckMethod() {
		log.info("Health check method");
		return ResponseEntity.ok("User Service health check successful...");
	}

	@PostMapping("/user/register")
	public ResponseEntity<?> register(@RequestBody User newUser) throws UserAlreadyRegisteredException {
		try {
			log.info("Registering new user...");
			userService.register(newUser);
			log.info("Registered new user...");
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (UserAlreadyRegisteredException e) {
			log.info("Exception -- User Already Registered!!!...");
			return new ResponseEntity<>("User Already Registered!!!", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestBody Credentials credentials) throws InvalidCredentialsException {
		
		try {
			String response = userService.login(credentials);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (InvalidCredentialsException e) {
			return new ResponseEntity<>("Invalid Username or Password!!!", HttpStatus.BAD_REQUEST);
		}
		
	}
}
