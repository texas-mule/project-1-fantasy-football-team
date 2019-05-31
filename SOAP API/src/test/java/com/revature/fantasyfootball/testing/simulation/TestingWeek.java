package com.revature.fantasyfootball.testing.simulation;

import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;
import com.revature.fantasyfootball.simulation.Week;

public class TestingWeek {
	
/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Testing Game Fields
	
		// Test League
			League testLeague = new League();
			
		// Test Teams
			ArrayList<Team> testTeams = new ArrayList<Team>();
				Team testTeamOne = new Team();
				Team testTeamTwo = new Team();
				Team testTeamThree = new Team();
				Team testTeamFour = new Team();
				
		// Test Game
			Week testWeek = new Week();
			
		// Week Number
			int week = 1;
						
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/	

	// Testing Game Methods

			@Test
			public void testingRunWeek() {
				System.out.println("TESTING Week");
				
				// Set Up
					
					// Initialize Teams
				
						// Team One
							testTeamOne.setTeamName("Test Team One");
							testTeamOne.setTeamFPS(new BigDecimal(10));
							testTeams.add(testTeamOne);
							
						// Team Two
							testTeamTwo.setTeamName("Test Team Two");
							testTeamTwo.setTeamFPS(new BigDecimal(20));
							testTeams.add(testTeamTwo);
						
						// Team Three
							testTeamThree.setTeamName("Test Team Three");
							testTeamThree.setTeamFPS(new BigDecimal(30));
							testTeams.add(testTeamThree);
							
						// Team Four
							testTeamFour.setTeamName("Test Team Four");
							testTeamFour.setTeamFPS(new BigDecimal(40));
							testTeams.add(testTeamFour);
								
					// Add Teams To League
						testLeague.setTeams(testTeams);
					
				// Implementation
						
					// Run Week
						testWeek.runWeek(testLeague, week);
					
				// Successful Test
					try {
						System.out.println("\n"+testWeek.printWeekResults());
						assertFalse(testWeek.getWeekVictors() == null);
						System.out.println("\nWEEK TEST SUCCEEDED");
					} catch (Exception e) {
						System.out.println("\nWEEK TEST FAILED");
					}
				
				// Seperate Tests
					System.out.println("\n----------\n");
				
			}
}