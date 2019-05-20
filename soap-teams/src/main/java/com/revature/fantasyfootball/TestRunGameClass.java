package com.revature.fantasyfootball;

import java.util.ArrayList;

public class TestRunGameClass {

	public void testingRunGameFunction(FantasyLeague gameTestLeague, int weekNumber, int gameNumber) {
		
		// Set Match Up
		System.out.println("\nSETTING MATCH UP\n----------------------");
			
			TestMatchSelectionClass matchForGame = new TestMatchSelectionClass();
			matchForGame.testingMatchSelectionFunction(gameTestLeague, weekNumber, gameNumber);
			
			matchForGame.match.printMatchUp();
			
		// Run Game Given Match Up
		System.out.println("RUNNING GAME\n");
		
		// Decide Victor
	
			// If Team Two Wins
				if(matchForGame.match.teamOne.getTeamFPS().compareTo(matchForGame.match.teamTwo.getTeamFPS())==-1) {
					for(FantasyTeam team:gameTestLeague.getTeams()) {
						if(matchForGame.match.teamTwo.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasWon();
						if(matchForGame.match.teamOne.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasLoss();
					}
				}
			
			// If Team One Wins
				if(matchForGame.match.teamOne.getTeamFPS().compareTo(matchForGame.match.teamTwo.getTeamFPS())==1) {
					for(FantasyTeam team:gameTestLeague.getTeams()) {
						if(matchForGame.match.teamOne.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasWon();
						if(matchForGame.match.teamTwo.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasLoss();
					}
				}
				
		// Display Results
				matchForGame.match.teamOne.printTeamStats();
				matchForGame.match.teamTwo.printTeamStats();
				
				System.out.println("------------------------------------------");
				
				gameTestLeague.displayTeamsByWinsStats();
		
	}
	
}
