package com.justintime.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.justintime.db.dbConnect;

public class Login {
	String email;
	String password;
	
	public static void main(String[] args) throws Exception {
		Connection con = dbConnect.getConnection();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("What do you want?");
			System.out.println("1. Employee Login");
			System.out.println("2. Manager Login");
			System.out.println("3. Admin Login");
			
			Integer ch =sc.nextInt();sc.nextLine();
			switch(ch) {
			case 1:
				Login emp = new Login();
				emp.getEmailPass();
				PreparedStatement pst = con.prepareStatement("select * from employee where email=? and password=? and manager=0");
				pst.setString(1, emp.email);
				pst.setString(2, emp.password);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					Integer id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String dept = rs.getString("dept");
					EmployeeImpl empi = new EmployeeImpl(id,name,email,dept);
					try {
						empi.request();
					} catch (Exception e) {
						System.out.println("Got an Exception. " +e);
					}
				}
				else {
					System.out.println("Wrong  Email and password");
				}
				break;
			case 2:
				Login manager = new Login();
				manager.getEmailPass();
				PreparedStatement ps = con.prepareStatement("select * from employee where email=? and password=? and manager=1");
				ps.setString(1, manager.email);
				ps.setString(2, manager.password);
				ResultSet rst = ps.executeQuery();
				if(rst.next()) {
					Integer id = rst.getInt("id");
					String name = rst.getString("name");
					String email = rst.getString("email");
					String dept = rst.getString("dept");
					ManagerImpl manage = new ManagerImpl(id,name,email,true,dept);
					try {
						manage.accept();
					} catch (Exception e) {
						System.out.println("Got an Exception. " +e);
					}
				}
				else {
					System.out.println("Wrong  Email and Password");
				}
				break;
			case 3:
				Login admin = new Login();
				admin.getEmailPass();
//				PreparedStatement pt = con.prepareStatement("select * from employee where email=? and password=? and manager=0");
//				pt.setString(1, admin.email);
//				pt.setString(2, admin.password);
//				ResultSet rts = pt.executeQuery();
				if(admin.email == "admin1@admin" && admin.password == "admin") {
					Admin empi = new Admin();
					int a = empi.stat();
				}
				else {
					System.out.println("Wrong  Email and password");
				}
				break;
			default:
				System.out.println("Sorry you entered a wrong choice!!");
				System.out.println("Please try again!");
				System.out.println("!!! QUITING !!!");
				sc.close();	
				System.exit(0);
				
			}	
		}
	}
	void getEmailPass() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email :");
		this.email = sc.nextLine();
		System.out.println("Enter your Password :");
		this.password = sc.nextLine();
		sc.close();	
	}
	

}
