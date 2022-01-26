package com.justintime.db;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import com.justintime.db.dbConnect;

import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author Sagnik
 *
 */
public class dbConnectTest extends TestCase {

	dbConnect c;
	Connection con;
	protected void setUp() throws Exception {
		c=new dbConnect();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cbs", "root", "root");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testGetConnection() throws Exception {
		assertEquals(con,c.getConnection());
	}

}
