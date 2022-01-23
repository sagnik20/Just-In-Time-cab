package com.justintime.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.justintime.db.dbConnect;
import com.justintime.exception.UnAvailableException;
import com.justintime.model.Cab;


public class BookingSystemImpl implements BookingSystem{
	
	private Set<Cab> cabs=new LinkedHashSet<>(); //A set of available Cabs

	@Override
	public void addCab(Cab newCab) throws Exception{
		Connection con=dbConnect.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into cab values (?,?,?,?);");
		pst.setInt(1, newCab.getCabNo());
		pst.setTime(2, newCab.getStartTiming());
		pst.setInt(3, newCab.getFreeOrBooked());
		pst.setTime(4, newCab.getEndTiming());
		
		cabs.add(newCab);
		
	}

	@Override
	public String requestCab() throws Exception{
		//invoked when employee raised a cab request
		//send an email to department head and approved
		if(cabs.isEmpty()) {
			try {
				throw new UnAvailableException("No Cab is Available");
			} catch (UnAvailableException e) {
				return(e.toString());
			}
		}
		
		for(Cab cab:cabs) 
			if(cab.getFreeOrBooked()==0) {
				cab.setFreeOrBooked(1);
				return cab.getCabNo()+" ";
			}
			
		try {
			throw new UnAvailableException("No Cab is Available");
		} catch (UnAvailableException e) {
			return(e.getMessage());
		}
		
	}

	@Override
	public Integer getNoOfAvailableCabs() throws Exception{
		Integer count=0;
		for(Cab cab:cabs) {
			if(cab.getFreeOrBooked()==0) {
				count++;
			}
		}
		return count;
	}
	

}
