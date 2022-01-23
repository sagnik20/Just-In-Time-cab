package com.justintime.client;

import com.justintime.model.Employee;

public class ManagerImpl extends Employee{
	
	public ManagerImpl(Integer id, String name, String email, Boolean manager, String dept) {
		super(id, name, email, manager, dept);
	}
	
	void accept(){
		
	}

}
