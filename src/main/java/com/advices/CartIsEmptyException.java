package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CartIsEmptyException extends Exception {
public static final long serialVersionUID =1L;
	
	public CartIsEmptyException(String message)
	{
		super (message);
	}
}
