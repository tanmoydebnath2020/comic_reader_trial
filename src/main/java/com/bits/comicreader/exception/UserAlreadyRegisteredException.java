package com.bits.comicreader.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User Already Registered!!!")

public class UserAlreadyRegisteredException extends RuntimeException {

	public UserAlreadyRegisteredException(String message) {
		super(message);
	}
}
