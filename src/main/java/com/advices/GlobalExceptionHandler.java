package com.advices;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(PayIdNotExistException.class)
  public ResponseEntity<?> resourceNotFoundException(PayIdNotExistException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CartIdNotExistException.class)
  public ResponseEntity<?> resourceNotFoundException(CartIdNotExistException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<?> resourceNotFoundException(CustomerNotFoundException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(UsernameNotExistException.class)
  public ResponseEntity<?> resourceNotFoundException(UsernameNotExistException ex, WebRequest request) {
       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<?> itemNotFoundException(ItemNotFoundException ix, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ix.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RestIdNotFoundException.class)
	public ResponseEntity<?> restIdNotFoundException(RestIdNotFoundException ex, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RestNameNotFoundException.class)
	  public ResponseEntity<?> resourceNotFoundException(RestNameNotFoundException ex, WebRequest request) {
	       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(CartIsEmptyException.class)
	  public ResponseEntity<?> resourceNotFoundException(CartIsEmptyException ex, WebRequest request) {
	       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	//handling custom valid errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException ex) {
	       ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "validationerror", ex.getBindingResult().getFieldError().getDefaultMessage());
	       return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  }
	
	
	  @ExceptionHandler(Exception.class) public ResponseEntity<?>
	  globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
	  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); return new ResponseEntity<>(errorDetails,
	  HttpStatus.INTERNAL_SERVER_ERROR); }
	 
}
