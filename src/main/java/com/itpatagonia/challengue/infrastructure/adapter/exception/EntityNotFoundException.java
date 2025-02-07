package com.itpatagonia.challengue.infrastructure.adapter.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message, HttpStatus errorCode) {
		super(message, errorCode);
	}

}
