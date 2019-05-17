package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

// Create A Game
public class Game {

	// Game Fields
		// Team One
		private FantasyTeam teamOne = new FantasyTeam();
		// Team Two
		private FantasyTeam teamTwo = new FantasyTeam();
		// Game Victor
		private FantasyTeam gameVictor;
		// Create Array of Available Teams
		private ArrayList<FantasyTeam> availableTeams = new ArrayList<>();
		
	// Create A Game
		public MatchUp scheduleGame(ArrayList<FantasyTeam> availableMatchTeams, int numberOfTeams) {
			availableTeams = availableMatchTeams;
			// Randomly Select Team One
				// Select Team
					teamOne = selectTeam(availableTeams, numberOfTeams);
					availableTeams.remove(teamOne);
					numberOfTeams--;
					
			// Randomly Select Team Two
				// Select Team
					teamTwo = selectTeam(availableTeams, numberOfTeams);
					availableTeams.remove(teamTwo);
					numberOfTeams--;
			
			// Document MatchUp
				// Create Match
				MatchUp gameMatch = new MatchUp();
				gameMatch.setTeamOne(teamOne);
				gameMatch.setTeamTwo(teamTwo);
				
			// Decide Victor
				BigDecimal x=teamOne.getTeamFPS();
				BigDecimal y=teamTwo.getTeamFPS();
				
				if(x.compareTo(y)==-1) {
					gameVictor = teamTwo;
					teamOne.teamHasLoss();
					teamTwo.teamHasWon();
				}
				if(x.compareTo(y)==1) {
					gameVictor = teamOne;
					teamOne.teamHasWon();
					teamTwo.teamHasLoss();
				}
				if(x.compareTo(y)==0)
					gameVictor = null;
		
			return gameMatch;
		}
		
	// Generate Random Team
		private FantasyTeam selectTeam(ArrayList<FantasyTeam> availableTeamsForRandomGenerator, int numberOfTeams) {
			FantasyTeam team = new FantasyTeam();
			Random randomSelector = new Random();
			team = availableTeamsForRandomGenerator.get(randomSelector.nextInt(numberOfTeams));
			return team;
		}

		@Override
		public String toString() {
			return "Game [availableTeams=" + availableTeams + "]";
		}

		public ArrayList<FantasyTeam> getAvailableTeams() {
			return availableTeams;
		}

		public FantasyTeam getGameVictor() {
			return gameVictor;
		}
}
