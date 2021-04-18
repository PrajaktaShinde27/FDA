package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class UsernameNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	public UsernameNotExistException(String message){
        super(message);
    }
}
