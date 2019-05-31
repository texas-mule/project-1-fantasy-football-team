package com.revature.fantasyfootball.testing.simulation;

import static org.junit.Assert.assertFalse;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;
import com.revature.fantasyfootball.simulation.MatchUp;

public class TestingMatchUp {
	
/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Testing MatchUp Fields
	
		// Test League
			League testLeague = new League();
			
		// Test Teams
			ArrayList<Team> testTeams = new ArrayList<Team>();
				Team testTeamOne = new Team();
				Team testTeamTwo = new Team();
				Team testTeamThree = new Team();
				
		// Test Match Up
				MatchUp testMatch = new MatchUp();
					
			
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/	

	// Testing MatchUp Methods

			@Test
			public void testingSelectMatchUp() {
				System.out.println("TESTING MATCHUP");
				
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
								
					// Add Teams To League
						testLeague.setTeams(testTeams);
					
				// Implementation
						
					// Select Match Up
						testMatch.selectMatchUp(testLeague);
					
				// Successful Test
					try {
						System.out.println("\n"+testMatch.toString());
						assertFalse(testMatch.getTeamOne().getTeamName().equalsIgnoreCase(testMatch.getTeamTwo().getTeamName()));
						System.out.println("\nMATCH TEST SUCCEEDED");
					} catch (Exception e) {
						System.out.println("\nMATCH TEST FAILED");
					}
				
				// Seperate Tests
					System.out.println("\n----------\n");
				
			}
}
