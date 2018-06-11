package com.stackthreads.ws.config;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stackthreads.ws.exceptions.UserNotFound;

@ControllerAdvice
@RestController
public class RestfulExceptionalHandler extends ResponseEntityExceptionHandler {

	/**
	 * to tell, apply this to all generic exception class
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * to tell, specific exception class
	 * exceptions here
	 */
	@ExceptionHandler(UserNotFound.class)
	protected ResponseEntity<Object> handleUserNotFoundException(UserNotFound ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
}
