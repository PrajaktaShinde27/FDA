package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RestIdNotFoundException extends Exception {
	
	private static final long serialVersionUID=2L;
	public RestIdNotFoundException(String message)
	{
		super(message);
	}
	

}

