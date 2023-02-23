package com.mx.xyz.handle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = 1291040466755008877L;

	public NoContentException(String msg) {
		super(msg);
	}

}
