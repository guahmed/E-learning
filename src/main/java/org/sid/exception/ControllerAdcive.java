


package org.sid.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdcive extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(value= {ChangePasswordException.class})
	public ResponseEntity<Object> HandelinvalidPassword(ChangePasswordException exc) {
		
		return new ResponseEntity<Object>(exc.getMessage(),HttpStatus.OK);
		
	}
}


