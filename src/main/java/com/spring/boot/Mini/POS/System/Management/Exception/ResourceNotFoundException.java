package com.spring.boot.Mini.POS.System.Management.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

	public ResourceNotFoundException(String resouceName, Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id = %d not found", resouceName, id));
	}

}
