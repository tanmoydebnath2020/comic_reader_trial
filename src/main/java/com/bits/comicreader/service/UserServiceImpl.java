package com.bits.comicreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.comicreader.dto.Credentials;
import com.bits.comicreader.exception.InvalidCredentialsException;
import com.bits.comicreader.exception.UserAlreadyRegisteredException;
import com.bits.comicreader.model.User;
import com.bits.comicreader.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public User register(User newUser) throws UserAlreadyRegisteredException {
		if (userRepository.findById(newUser.getEmailId()).isPresent()) {
			log.info("Exception -- User Already Registered!!!...");
			throw new UserAlreadyRegisteredException("User Already Registered!!!");
		} else {
			log.info("Registering new user...");
			return userRepository.save(newUser);
		}
	}

	public String login(Credentials credentials) throws InvalidCredentialsException {
		log.info("Validating Email ID and Password...");
		User user = userRepository.findByEmailIdAndPassword(credentials.getEmailId(), credentials.getPassword());
		if (user == null) {
			throw new InvalidCredentialsException("Invalid Username or Password!!!");
		} else {
			log.info("Validating Email ID and Password...");
			if (user.getEmailId().equals(credentials.getEmailId())) {
				return "Login Successful";
			}

		}
		return null;

	}
}
