package com.project.exceptions;

public class CharacterException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final String message = "The first character is not alphabeth";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}


}
