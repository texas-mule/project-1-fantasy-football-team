package com.revature.fantasyfootball.testing.simulation;

import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;
import com.revature.fantasyfootball.simulation.Game;

public class TestingGame {
	
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
				
		// Test Game
			Game testGame = new Game();
						
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/	

	// Testing Game Methods

			@Test
			public void testingRunGame() {
				System.out.println("TESTING GAME");
				
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
						
					// Run Game
						testGame.runGame(testLeague);
					
				// Successful Test
					try {
						System.out.println("\n"+testGame.printGameResults());
						assertFalse(testGame.getGameMatchUp() == null);
						System.out.println("\nGAME TEST SUCCEEDED");
					} catch (Exception e) {
						System.out.println("\nGAME TEST FAILED");
					}
				
				// Seperate Tests
					System.out.println("\n----------\n");
				
			}
}
