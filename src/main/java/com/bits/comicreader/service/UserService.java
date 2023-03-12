package com.bits.comicreader.service;

import com.bits.comicreader.dto.Credentials;
import com.bits.comicreader.exception.InvalidCredentialsException;
import com.bits.comicreader.exception.UserAlreadyRegisteredException;
import com.bits.comicreader.model.User;

public interface UserService {

	public User register(User newUser) throws UserAlreadyRegisteredException;
	
	public String login(Credentials credentials) throws InvalidCredentialsException;
}
