package org.sid.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




public class ChangePasswordException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ChangePasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChangePasswordException(String message) {
		super(message);
	}


	

}
