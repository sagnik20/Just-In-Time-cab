package com.justintime.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.justintime.db.dbConnect;
import com.justintime.model.Cab;
import com.justintime.service.BookingSystemImpl;

public class Admin {
	int stat() {
		System.out.println("!!! WELCOME to Admin Login !!!");
		while(true) {
			System.out.println("What do you wanna do?");
			System.out.println("1. Add Employee");
//			System.out.println("2. Delete Employee");
			System.out.println("2. Add Cab");
			System.out.println("3. Check Requests");
			System.out.println("Press anything else to Log Out!");
			Scanner sc =new Scanner(System.in);
			Integer ch = sc.nextInt();
			Admin a = new Admin();
			switch (ch) {
			case 1:
				a.addEmp();break;
			/*
			 * case 2: a.removeEmp(); break;
			 */
			case 2:
				a.addCab();
				break;
			case 3:
				a.checkRequest();
				break;
			default:
				System.out.println("Logging Out!");
				return 0;
			}
		}
	}
	
	void addEmp() {
		Connection con = dbConnect.getConnection();
		PreparedStatement pt = con.prepareStatement("insert into employee values(?,?,?,?,?)");
		pt.setString(1, );
		pt.setString(2, );
		
	}
	
	/*
	 * void removeEmp() {
	 * 
	 * }
	 */
	void addCab() {
		System.out.println("Enter Cab Number: ");
		Scanner sc =new Scanner(System.in);
		Integer CNo = sc.nextInt();
		Cab newCab = new Cab(CNo);
		BookingSystemImpl bs =new BookingSystemImpl();
		try {
			bs.addCab(newCab);
		} catch (Exception e) {
			System.out.println("Got an Exception. " +e);
		}
		
	}
	
	void checkRequest() {
		
	}


}
