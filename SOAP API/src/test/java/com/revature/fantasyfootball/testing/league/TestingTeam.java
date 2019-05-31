package com.revature.fantasyfootball.testing.league;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.fantasyfootball.league.Team;

// Create An Object That Test Team Object
public class TestingTeam {

	// Test Win Function
	@Test
	public void winFunctionTest() {
		
		System.out.println("TESTING TEAM WIN FUNCTION\n");
		
		// Parameters
		
			// Team
				Team testTeam = new Team();
				testTeam.setTeamName("Test Team");
				
		// Implementation
			testTeam.teamWon();
			System.out.println(testTeam.toString());
				
		// Successful Test
			try {
				assertTrue(testTeam.getTeamWinStat()==1);
			} catch (Exception e) {
				System.out.println("WIN TEST FAILED");
			}
			
		// Seperate Tests
			System.out.println("\n----------\n");
	}
	
	@Test
	public void loseFunctionTest() {
		
		System.out.println("TESTING TEAM LOSE FUNCTION\n");
		// Parameters
			Team testTeam = new Team();
			testTeam.setTeamName("Test Team");
			
		// Implementation
			testTeam.teamLost();
			System.out.println(testTeam.toString());
			
		// Successful Test
			try {
				assertTrue(testTeam.getTeamLossStat()==1);
			} catch (Exception e) {
				System.out.println("LOSE TEST FAILED");
			}
			
		// Seperate Tests
			System.out.println("\n----------\n");
	}

}
