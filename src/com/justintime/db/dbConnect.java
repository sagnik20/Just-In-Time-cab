package com.justintime.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
	public static Connection getConnection() throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cab", "root", "root");
		return con;
	}

}
