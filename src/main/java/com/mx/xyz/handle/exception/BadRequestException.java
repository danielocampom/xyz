package com.mx.xyz.handle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 7684598669127461111L;

	public BadRequestException(String msg) {
		super(msg);
	}

}
