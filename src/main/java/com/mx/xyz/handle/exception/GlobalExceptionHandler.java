package com.mx.xyz.handle.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mx.xyz.vo.ErrorResponseVO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<?> handleException(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponseVO("Error interno del servidor"));
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public ResponseEntity<?> handleBadRequest(BadRequestException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseVO(e.getMessage()));
	}

	@ExceptionHandler(NoContentException.class)
	@ResponseBody
	public ResponseEntity<?> handleNoContentException(NoContentException e) {
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseVO("Cuerpo de solicitud no valido"));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<ErrorResponseVO> list = new ArrayList<>();
		e.getAllErrors().forEach(err -> list.add(new ErrorResponseVO(err.getDefaultMessage())));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
	}

}
