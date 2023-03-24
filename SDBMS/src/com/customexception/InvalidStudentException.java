package com.customexception;

public class InvalidStudentException extends RuntimeException{
private String message;

public InvalidStudentException(String message) {
	super();
	this.message = message;
}
public String getMessage()
{
	return message;
}
}
