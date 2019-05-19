package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Create An Object To Represent A Game
public class Game {

/*******************************************************************************************************************************************/
/********************************************************* GAME FIELDS *********************************************************************/
/*******************************************************************************************************************************************/

	// Game Fields
	
		// Match Up
			private MatchUp gameMatchUp = new MatchUp();
		
		// Game Victor
			private FantasyTeam gameVictor;
		
		// Game Loser
			private FantasyTeam gameLoser;
			
		// Create Array of Available Teams
			private ArrayList<FantasyTeam> availableTeams = new ArrayList<>();
		
/*******************************************************************************************************************************************/
/*********************************************** GAME GETTERS ANDS SETTERS *****************************************************************/
/*******************************************************************************************************************************************/	
	
	// Game Getters and Setters
			
			// Match Up
				public void setGameMatchUp(MatchUp gameMatchUp) {
					this.gameMatchUp = gameMatchUp;
				}
				public MatchUp getGameMatchUp() {
					return gameMatchUp;
				}
			
			// Victor
				public void setGameVictor(FantasyTeam gameVictor) {
					this.gameVictor = gameVictor;
				}
				public FantasyTeam getGameVictor() {
					return gameVictor;
				}
			
			// Loser
				public void setGameLoser(FantasyTeam gameLoser) {
					this.gameLoser = gameLoser;
				}

				public FantasyTeam getGameLoser() {
					return gameLoser;
				}
			
			// Available Teams
				public void setAvailableTeams(ArrayList<FantasyTeam> availableTeams) {
					this.availableTeams = availableTeams;
				}

				public ArrayList<FantasyTeam> getAvailableTeams() {
					return availableTeams;
				}
			
/*******************************************************************************************************************************************/
/************************************************* GAME FUNCTIONS **************************************************************************/
/*******************************************************************************************************************************************/
		
	// Game Functions
			
			// Select Teams For Games
			// selects random team
				public MatchUp selectTeamsForMatchUp(ArrayList<FantasyTeam> availableTeamsForRandomGenerator, int numberOfTeamsForRandomGenerator, ArrayList<MatchUp> previouslySelectedMatches) {
					
					// Method Fields
					
						// Number of Teams to Select From
							int numberOfTeamsForRandomGeneratorAttempt = numberOfTeamsForRandomGenerator;
				
						// Available Teams to Select From
							ArrayList<FantasyTeam> availableTeamsForRandomGeneratorAttempt = availableTeamsForRandomGenerator;
							
						// Iterator to scan through previous matches
							Iterator<MatchUp> scanPreviousMatches = previouslySelectedMatches.iterator();
							
						// Previous Matches
							MatchUp previousMatchUp = new MatchUp();
							
						// Random Integer
							Random randomSelector = new Random();
							
						// Fantasy Team To Be Selected
							FantasyTeam team = new FantasyTeam();
							
					// Method Implementation
							
						// Select Team One
							gameMatchUp.setTeamOne(availableTeamsForRandomGeneratorAttempt.get(randomSelector.nextInt(numberOfTeamsForRandomGeneratorAttempt)));
							team = gameMatchUp.getTeamOne();
							availableTeamsForRandomGeneratorAttempt.remove(team);
							numberOfTeamsForRandomGeneratorAttempt--;
							
						// Select Team Two
							gameMatchUp.setTeamTwo(availableTeamsForRandomGeneratorAttempt.get(randomSelector.nextInt(numberOfTeamsForRandomGeneratorAttempt)));
							team = gameMatchUp.getTeamTwo();
							availableTeamsForRandomGeneratorAttempt.remove(team);
							numberOfTeamsForRandomGeneratorAttempt--;
							
						// Check Match Up
							for(int i = 0; i<previouslySelectedMatches.size();i++) {
								previousMatchUp.equals(scanPreviousMatches.next());
								if(gameMatchUp.teamOne.equals(previousMatchUp.teamOne) && gameMatchUp.teamTwo.equals(previousMatchUp.teamTwo)
										|| gameMatchUp.teamOne.equals(previousMatchUp.teamTwo) && gameMatchUp.teamTwo.equals(previousMatchUp.teamOne)) {
									
									gameMatchUp = selectTeamsForMatchUp(availableTeamsForRandomGenerator, numberOfTeamsForRandomGenerator, previouslySelectedMatches);	
								}	
							}
					
					return gameMatchUp;
				}
				
				
				
			// Run A Game
			// initiates a game
				public void runGame(ArrayList<FantasyTeam> availableTeamsForRandomGenerator, int numberOfTeamsForRandomGenerator, ArrayList<MatchUp> previouslySelectedMatches, BigDecimal teamOneFPS, BigDecimal teamTwoFPS) {
					
					
					selectTeamsForMatchUp(availableTeamsForRandomGenerator, numberOfTeamsForRandomGenerator, previouslySelectedMatches);
					
					gameMatchUp.getTeamOne().setTeamFPS(teamOneFPS);
					gameMatchUp.getTeamTwo().setTeamFPS(teamTwoFPS);
					
					// Decide Victor
					BigDecimal x=gameMatchUp.teamOne.getTeamFPS();
					BigDecimal y=gameMatchUp.teamTwo.getTeamFPS();
					
					if(x.compareTo(y)==-1) {
						gameVictor = gameMatchUp.teamTwo;
						gameLoser = gameMatchUp.teamOne;
						gameMatchUp.teamOne.teamHasLoss();
						gameMatchUp.teamTwo.teamHasWon();
					}
					if(x.compareTo(y)==1) {
						gameVictor = gameMatchUp.teamOne;
						gameLoser = gameMatchUp.teamTwo;
						gameMatchUp.teamOne.teamHasWon();
						gameMatchUp.teamTwo.teamHasLoss();
					}
					if(x.compareTo(y)==0)
						gameVictor = null;
					
				}

		@Override
		public String toString() {
			return "Game [availableTeams=" + availableTeams + "]";
		}
}
