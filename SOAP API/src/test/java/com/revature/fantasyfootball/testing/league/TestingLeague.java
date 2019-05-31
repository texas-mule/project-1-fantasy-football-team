package com.revature.fantasyfootball.testing.league;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.revature.fantasyfootball.league.League;

public class TestingLeague {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Testing League Fields
	
		// Test League
			League testLeague = new League();
			
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/	

	// Testing League Methods

		// Implementation
			@Test
			public void testingCreateLeague() {
				System.out.println("TESTING LEAGUE");
				
				// Set League Name
					String newLeagueName = "TestLeague";
					
				// Set Team Names
					ArrayList<String> teamNames = new ArrayList<String>();
						teamNames.add("Test Team One");
						teamNames.add("Test Team Two");
						teamNames.add("Test Team Three");
				
				// Create League
					testLeague.createLeague(newLeagueName, teamNames, testLeague);
					
				// Successful Test
					try {
						assertTrue(testLeague.getLeagueName().equalsIgnoreCase("TestLeague"));
					} catch (Exception e) {
						System.out.println("\nLEAGUE TEST FAILED\n");
						
					// Separate Tests
						System.out.println("\n----------\n");
						
						fail();
					}
				
				// Separate Tests
					System.out.println("\n----------\n");
				
			}

}
