package com.rest.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/** 
 * Error class. Should house information on any exceptions raised.
 * @author ian
 *
 */
public class Error {
	 	private HttpStatus returnStatus;

	    private LocalDateTime errorTime;

	    private String errorMessage;

	    private String errorDetails;

	    public Error(HttpStatus returnStatus, String errorMessage, String errorDetails) 
	    {
	        this.returnStatus = returnStatus;
	        this.errorTime = LocalDateTime.now();
	        this.errorMessage = errorMessage;
	        this.errorDetails = errorDetails;
	    }

	    public HttpStatus getReturnStatus() 
	    {
	        return returnStatus;
	    }

	    public LocalDateTime getErrorTime() 
	    {
	        return errorTime;
	    }

	    public String getErrorMessage()
	    {
	        return errorMessage;
	    }

	    public String getErrorDetails() 
	    {
	        return errorDetails;
	    }
}
