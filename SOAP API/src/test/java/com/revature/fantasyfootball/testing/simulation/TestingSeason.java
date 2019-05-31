package com.revature.fantasyfootball.testing.simulation;

import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;
import com.revature.fantasyfootball.simulation.Season;

public class TestingSeason {
	
/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Testing Season Fields
	
		// Test League
			League testLeague = new League();
			
		// Test Teams
			ArrayList<Team> testTeams = new ArrayList<Team>();
				Team testTeamOne = new Team();
				Team testTeamTwo = new Team();
				Team testTeamThree = new Team();
				Team testTeamFour = new Team();
				
		// Test Season
			Season testSeason = new Season();
			
		// Week Number
			int week = 1;
			
		// Year
			int year = 2019;
						
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/	

	// Testing Season Methods

			@Test
			public void testingRunSeason() {
				System.out.println("TESTING SEASON");
				
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
						
					// Run Season
						testSeason.runSeason(testLeague, year, week);
					
				// Successful Test
					try {
						System.out.println("\n"+testSeason.toString());
						assertFalse(testSeason.getSeasonChampion() == null);
						System.out.println("\nSEASON TEST SUCCEEDED");
					} catch (Exception e) {
						System.out.println("\nSEASON TEST FAILED");
					}
				
				// Seperate Tests
					System.out.println("\n----------\n");
				
			}
}