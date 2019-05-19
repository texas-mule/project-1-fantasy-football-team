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
			
			// Run A Game
			// initiates a game
				public MatchUp setGame(ArrayList<FantasyTeam> availableTeamsForGame, int numberOfTeamsForGame, ArrayList<MatchUp> previouslySelectedMatches) {
					System.out.println(availableTeamsForGame.size());
					System.out.println(availableTeamsForGame);
					// Set Match Up
						this.gameMatchUp.setMatchUp(availableTeamsForGame, numberOfTeamsForGame, previouslySelectedMatches);
					
					System.out.println("RUNNING GAME");
					
					// Decide Victor
						BigDecimal x=this.gameMatchUp.teamOne.getTeamFPS();
						System.out.println(x);
						BigDecimal y=this.gameMatchUp.teamTwo.getTeamFPS();
						System.out.println(y);
				
						// If Team Two Wins
							if(x.compareTo(y)==-1) {
								this.gameVictor = this.gameMatchUp.teamTwo;
								this.gameLoser = this.gameMatchUp.teamOne;
								this.gameMatchUp.teamOne.teamHasLoss();
								this.gameMatchUp.teamTwo.teamHasWon();
							}
						
						// If Team One Wins
							if(x.compareTo(y)==1) {
								this.gameVictor = this.gameMatchUp.teamOne;
								this.gameLoser = this.gameMatchUp.teamTwo;
								this.gameMatchUp.teamOne.teamHasWon();
								this.gameMatchUp.teamTwo.teamHasLoss();
							}
						
						// If Its A Draw
							if(x.compareTo(y)==0)
								this.gameVictor = null;
					
					return gameMatchUp;
				}

		@Override
		public String toString() {
			return "Game [availableTeams=" + availableTeams + "]";
		}
}
