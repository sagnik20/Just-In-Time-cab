package com.justintime.client;

import com.justintime.model.Employee;

public class EmployeeImpl extends Employee{

	public EmployeeImpl(Integer id, String name, String email, String dept) {
		super(id, name, email, dept);
		
	}
	
	void request() {
		System.out.println("Do you want to request a cab?");
		System.out.println("Press 1 to book");
	}



}
