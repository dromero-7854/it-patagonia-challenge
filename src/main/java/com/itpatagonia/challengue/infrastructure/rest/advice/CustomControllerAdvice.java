package com.itpatagonia.challengue.infrastructure.rest.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.itpatagonia.challengue.infrastructure.adapter.exception.BusinessException;
import com.itpatagonia.challengue.infrastructure.adapter.exception.EntityNotFoundException;

@ControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorDetails> handleBusinessException(BusinessException businessException,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), businessException.getErrorMessage(),
				request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEntityNotFoundException(EntityNotFoundException businessException,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), businessException.getErrorMessage(),
				request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
