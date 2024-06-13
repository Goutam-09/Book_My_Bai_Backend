package com.dollop.bai.exceptions;

public class DublicateEntryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DublicateEntryException() {
		super();
	}

	public DublicateEntryException(String message) {
		super(message);
	}

}
