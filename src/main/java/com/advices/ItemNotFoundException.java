package com.advices;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends Exception{

	private static final long serialVersionUID=1L;
	public ItemNotFoundException(String message)
	{
		super(message);
	}
	
}

