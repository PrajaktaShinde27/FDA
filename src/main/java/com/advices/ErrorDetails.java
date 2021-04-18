package com.advices;


import java.time.LocalDateTime;

public class ErrorDetails {
	
	// private Date timestamp;
	private  LocalDateTime ldt;
	  private String message;
	  private String details;
	    
	    public ErrorDetails(LocalDateTime ldt, String message, String details) {
	        super();
	        //this.timestamp = LocalDateTime;
	        this.ldt=ldt;
	        this.message = message;
	        this.details = details;
	    }

	    public LocalDateTime getTimestamp() {
	        return ldt;
	    }

	    public String getMessage() {
	         return message;
	    }

	    public String getDetails() {
	         return details;
	    }

}
