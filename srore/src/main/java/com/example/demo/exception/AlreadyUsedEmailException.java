package com.example.demo.exception;

public class AlreadyUsedEmailException extends StoreException {

	public AlreadyUsedEmailException(String message) {
		super(message);
	}
}
