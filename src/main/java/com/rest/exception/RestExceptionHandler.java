package com.rest.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;



@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * Should raise a new exception when a a given entity is called for by a REST call which does not exist.
	 * @param ex
	 * @return a response entity with the error object and the HTTP status.
	 */
	@ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<Error> handleEntityNotFound(EntityNotFoundException exception)
	{
		Error error = new Error(HttpStatus.NOT_FOUND, "Entity not found", exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	/**
	 * Should raise a new exception when one of the input pieces of data does not conform to the validation needs put in place for one of the transfer objects.
	 */
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) 
	{
            Error error = new Error(HttpStatus.BAD_REQUEST, "Validation Error", exception.getBindingResult().toString());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
