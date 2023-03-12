package com.bits.comicreader.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Username or Password!!!")
public class InvalidCredentialsException extends Exception {

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
