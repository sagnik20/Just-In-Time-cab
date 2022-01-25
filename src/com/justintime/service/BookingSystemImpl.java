package com.justintime.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.justintime.dao.BookingImpl;
import com.justintime.db.dbConnect;
import com.justintime.exception.UnAvailableException;
import com.justintime.model.Cab;


public class BookingSystemImpl implements BookingSystem{
	
	private Set<Cab> cabs=new LinkedHashSet<>(); //A set of available Cabs

	@Override
	public void addCab(Cab newCab) throws Exception{
		Connection con=dbConnect.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into cab(cabNo,freeOrBooked) values (?,?);");
		pst.setInt(1, newCab.getCabNo());
		pst.setInt(2, newCab.getFreeOrBooked());
		pst.execute(); //insert
		
		BookingImpl bi = new BookingImpl();
		cabs = bi.copycabs();
		cabs.add(newCab);
		
	}

	@Override
	public Integer requestCab() throws Exception{
		BookingImpl bi = new BookingImpl();
		cabs = bi.copycabs();
		if(cabs.isEmpty()) {
			try {
				throw new UnAvailableException("No Cab is Available");
			} catch (UnAvailableException e) {
				System.out.println(e.toString());
				return -1;
			}
		}
		
		for(Cab cab:cabs) 
			if(cab.getFreeOrBooked()==0) {
				cab.setFreeOrBooked(1);
				return cab.getCabNo();
			}
			
		try {
			throw new UnAvailableException("No Cab is Available");
		} catch (UnAvailableException e) {
			System.out.println(e.getMessage());
			return-1;
		}
		
	}

	@Override
	public Integer getNoOfAvailableCabs() throws Exception{
		BookingImpl bi = new BookingImpl();
		cabs = bi.copycabs();
		Integer count=0;
		for(Cab cab:cabs) {
			if(cab.getFreeOrBooked()==0) {
				count++;
			}
		}
		return count;
	}
	

	

}
