package com.itpatagonia.challengue.infrastructure.adapter.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;

	private HttpStatus errorCode;

}
