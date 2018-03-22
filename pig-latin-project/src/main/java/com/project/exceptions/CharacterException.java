package com.project.exceptions;

public class CharacterException extends Exception {

	
	private static final long serialVersionUID = -1866578464044030905L;
	
	private final String message = "charakter nie je pismeno";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}


}
