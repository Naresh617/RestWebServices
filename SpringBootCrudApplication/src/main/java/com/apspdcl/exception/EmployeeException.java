package com.apspdcl.exception;

public class EmployeeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorMessage;
	
	 public String getErrorMessage() {
	        return errorMessage;
	    }
	 
	 public EmployeeException(String errorMessage) {
	        super(errorMessage);
	        this.errorMessage = errorMessage;
	    }
}
