package com.gallo.examen01.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gallo.examen01.exception.GeneralException;
import com.gallo.examen01.exception.NoDataFoundException;
import com.gallo.examen01.exception.ValidateException;
import com.gallo.examen01.util.WrapperResponse;

@ControllerAdvice
public class ErrorHandlerConfig {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> all(Exception e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal server error", null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidateException.class)
	public ResponseEntity<?> validation(ValidateException e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<?> validation(NoDataFoundException e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<?> validation(GeneralException e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal server error", null);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
