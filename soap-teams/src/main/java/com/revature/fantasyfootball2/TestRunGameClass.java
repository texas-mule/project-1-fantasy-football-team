package com.revature.fantasyfootball2;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.jws.WebParam;

public class TestRunGameClass {

	public void testingSetGameFunction(int numberOfTeamsForGame, ArrayList<MatchUp> seasonMatchUps, FantasyLeague gameTestLeague) {
		
		// Set Match Up
		System.out.println("SETTING MATCH UP\n----------------------");
			
			TestMatchSelectionClass matchForGame = new TestMatchSelectionClass();
			matchForGame.testingMatchSelectionFunction(seasonMatchUps, gameTestLeague);
	
		// Run Game Given Match Up
		System.out.println("RUNNING GAME\n");
		
		// Decide Victor
	
			// If Team Two Wins
				if(matchForGame.getMatch().teamOne.getTeamFPS().compareTo(matchForGame.getMatch().teamTwo.getTeamFPS())==-1) {
					for(FantasyTeam team:gameTestLeague.getTeams()) {
						if(matchForGame.getMatch().teamTwo.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasWon();
						if(matchForGame.getMatch().teamOne.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasLoss();
					}
				}
			
			// If Team One Wins
				if(matchForGame.getMatch().teamOne.getTeamFPS().compareTo(matchForGame.getMatch().teamTwo.getTeamFPS())==1) {
					for(FantasyTeam team:gameTestLeague.getTeams()) {
						if(matchForGame.getMatch().teamTwo.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasWon();
						if(matchForGame.getMatch().teamOne.getTeamName().equalsIgnoreCase(team.getTeamName()))
							team.teamHasLoss();
					}
				}
				
		// Display Results
				matchForGame.getMatch().teamOne.printTeamStats();
				matchForGame.getMatch().teamTwo.printTeamStats();
				
				gameTestLeague.displayTeamsByWins();
		
	}

	public void testingRunGameFunction(ArrayList<MatchUp> seasonMatchUps, FantasyLeague weekTestLeague) {
		// TODO Auto-generated method stub
		
	}
	
	
}
