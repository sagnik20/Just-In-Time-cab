package com.justintime.service;

import com.justintime.exception.UnAvailableException;
import com.justintime.modal.Cab;

public interface BookingSystem {
	
	void addCab(Cab newCab);
	String requestCab() throws UnAvailableException;
	Integer getNoOfAvailableCabs();
	

}
