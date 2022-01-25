package com.justintime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.justintime.db.dbConnect;
import com.justintime.model.Cab;

public class BookingImpl implements Booking{

	@Override
	public Set<Cab> copycabs() {
		Set<Cab> cabs=new LinkedHashSet<>();
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement pt = con.prepareStatement("select cabNo,freeOrBooked from cab");
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				Integer cabNo = rs.getInt(1);
				Integer fOB = rs.getInt(2);
				Cab a = new Cab(cabNo,fOB);
				cabs.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cabs;
	}

}
