package com.justintime.service;

import java.util.HashSet;
import java.util.Set;

import com.justintime.exception.UnAvailableException;
import com.justintime.modal.Cab;

public class BookingSystemImpl implements BookingSystem{
	
	private Set<Cab> cabs=new HashSet<>(); //A set of available Cabs

	@Override
	public void addCab(Cab newCab) {
		cabs.add(newCab);
		
	}

	@Override
	public String requestCab() throws UnAvailableException {
		//invoked when employee raised a cab request
		//send an email to department head and approved
		
		for(Cab cab:cabs) 
			if(cab.getFreeOrBooked()==0) {
				cab.setFreeOrBooked(1);
				return cab.getCabNo();
			}
			
		throw new UnAvailableException("No Cab is Available");
		
	}

	@Override
	public Integer getNoOfAvailableCabs() {
		return cabs.size();		
	}
	

}
