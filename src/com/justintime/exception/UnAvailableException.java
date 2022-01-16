package com.justintime.exception;

public class UnAvailableException extends Exception{
	
	public UnAvailableException(String s) {
		super(s);
	}

	@Override
	public String toString() {
		return "Currently No Cab is available for booking.\nPlease try again after few minutes.";
	}
	
	@Override
	public String getMessage() {
		return "All cabs are booked";
	}
	

}
