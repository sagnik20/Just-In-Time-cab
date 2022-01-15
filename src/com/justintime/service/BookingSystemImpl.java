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
	public String requestCab() {
		//invoked when employee raised a cab request
		//send an email to department head and approved
		
		for(Cab cab:cabs) 
			if(cab.getFreeOrBooked()==0) {
				cab.setFreeOrBooked(1);
				return cab.getCabNo();
			}
			
		try {
			throw new UnAvailableException("No Cab is Available");
		} catch (UnAvailableException e) {
			// TODO Auto-generated catch block
			return(e.toString());
		}
		
	}

	@Override
	public Integer getNoOfAvailableCabs() {
		Integer count=0;
		for(Cab cab:cabs) {
			if(cab.getFreeOrBooked()==0) {
				count++;
			}
		}
		return count;
	}
	

}
