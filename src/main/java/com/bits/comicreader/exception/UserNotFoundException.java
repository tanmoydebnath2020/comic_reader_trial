package com.bits.comicreader.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not Found!!!")
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String message)
	{
		super(message);
	}
}
