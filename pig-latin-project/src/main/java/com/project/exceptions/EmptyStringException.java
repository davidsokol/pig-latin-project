package com.project.exceptions;

public class EmptyStringException extends StringIndexOutOfBoundsException {

	private static final long serialVersionUID = 1L;

	private static final String message = "String is empty.";

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}
}
