package com.webzifi.app.ws.exceptions;

import java.net.http.HttpHeaders;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.webzifi.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		String errMessageDescription = ex.getLocalizedMessage();
		if(errMessageDescription == null) errMessageDescription = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errMessageDescription);
		return new ResponseEntity<>(
				errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request){
		String errMessageDescription = ex.getLocalizedMessage();
		if(errMessageDescription == null) errMessageDescription = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errMessageDescription);
		return new ResponseEntity<>(
				errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
