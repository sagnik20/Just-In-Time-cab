package com.justintime.modal;

import java.util.Date;
import java.util.Objects;
import java.util.Calendar;


public class Cab {
	private final String cabNo;
	private Date timing;
	private Integer freeOrBooked;//0 means available, 1 means Booked
	
	public Cab(String cnum) {
		this.cabNo = cnum;
		Calendar cal = Calendar.getInstance();
		this.timing = cal.getTime();
		this.freeOrBooked = 0;
		
	}
	
	public Integer getFreeOrBooked() {
		return freeOrBooked;
	}

	public void setFreeOrBooked(Integer freeOrBooked) {
		this.freeOrBooked = freeOrBooked;
	}


	public String getCabNo() {
		return cabNo;
	}

	public Date getTiming() {
		return timing;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cabNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		return Objects.equals(cabNo, other.cabNo);
	}
	
	

		

}
