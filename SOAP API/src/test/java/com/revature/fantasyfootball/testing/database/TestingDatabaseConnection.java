package com.revature.fantasyfootball.testing.database;
import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.fantasyfootball.database.*;
// Create a JUnit Test Case for DataBase Connection
public class TestingDatabaseConnection {

	@Test
	public void testingLeagueConnection() {

		System.out.println("TESTING CONNECTION ESTABLISHMENT\n");
		// Parameters
			DatabaseConnection testConnection = new DatabaseConnection();

		// Implementation
			try {
				// Connect To Database
					testConnection.connectToLeagueDatabase();
					
				// Test Connection
					assertNotNull(testConnection.getConnection());
					System.out.println(testConnection.toString());
					
			} catch (Exception e) {
				System.out.println("CONNECTION TEST FAILED");
			}
	
		// Seperate Tests
			System.out.println("\n----------\n");
	
	}
}
