package Staff.Api.restaurant.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		System.err.println("Exception caught: " + ex.getMessage());
		return new ResponseEntity<>("An error occured: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
