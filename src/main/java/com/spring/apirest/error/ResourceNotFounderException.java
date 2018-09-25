package com.spring.apirest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFounderException extends RuntimeException {

	/**
	 * guilherme rosa dos santos
	 */
	
	private static final long serialVersionUID = -6551416998954253983L;
	
	public ResourceNotFounderException(String message) {
		super(message);
	}

}
