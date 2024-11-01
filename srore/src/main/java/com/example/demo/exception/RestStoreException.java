package com.example.demo.exception;

public class RestStoreException extends RuntimeException {

	public RestStoreException(String message) {
		super(message);
	}
	
	public RestStoreException(String message, Throwable cause) {
		super(message, cause);
	}
}
