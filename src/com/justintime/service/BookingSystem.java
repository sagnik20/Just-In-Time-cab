package com.justintime.service;

import com.justintime.model.Cab;

public interface BookingSystem{
	
	void addCab(Cab newCab) throws Exception;
	String requestCab() throws Exception;
	Integer getNoOfAvailableCabs() throws Exception;
	

}
