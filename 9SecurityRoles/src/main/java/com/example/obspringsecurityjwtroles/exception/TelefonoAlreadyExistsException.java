package com.example.obspringsecurityjwtroles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TelefonoAlreadyExistsException extends ResponseStatusException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelefonoAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
