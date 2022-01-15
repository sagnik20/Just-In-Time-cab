package com.justintime.service;

import com.justintime.modal.Cab;

public interface BookingSystem {
	
	void addCab(Cab newCab);
	String requestCab();
	Integer getNoOfAvailableCabs();
	

}
