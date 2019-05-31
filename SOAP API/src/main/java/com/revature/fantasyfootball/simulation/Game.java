package com.revature.fantasyfootball.simulation;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;

// Create An Object To Represent A Game
public class Game {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Game Fields
	
		// Match Up
			private MatchUp gameMatchUp = new MatchUp();
			
		// Victor
			private Team victor;
			
		// Loser
			private Team loser;
			
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/

	// Game Getters and Setters
			
			// Match Up
				public MatchUp getGameMatchUp() {
					return gameMatchUp;
				}
	
				public void setGameMatchUp(MatchUp gameMatchUp) {
					this.gameMatchUp = gameMatchUp;
				}
				
			// Victor
				public Team getVictor() {
					return victor;
				}

				public void setVictor(Team victor) {
					this.victor = victor;
				}
				
			// Loser
				public Team getLoser() {
					return loser;
				}

				public void setLoser(Team loser) {
					this.loser = loser;
				}
				
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/
	
	// Game Methods
				
		// Run A Game
			public void runGame(League league) {
				
				// Parameters
					
					// Match
						gameMatchUp.selectMatchUp(league);
						
				// Implementation
					
					// Decide Victor
						
						System.out.println(league.getTeams().toString());
						// Team Two Won
							if(gameMatchUp.getTeamOne().getTeamFPS().compareTo(gameMatchUp.getTeamTwo().getTeamFPS())==-1){
								this.victor = gameMatchUp.getTeamTwo();
									gameMatchUp.getTeamTwo().teamWon();
								this.loser = gameMatchUp.getTeamOne();
									gameMatchUp.getTeamOne().teamLost();
									
								System.out.println(this.getVictor().printStats());
								System.out.println(this.getLoser().printStats());
							}
							
						// Team One Won
							else if(gameMatchUp.getTeamOne().getTeamFPS().compareTo(gameMatchUp.getTeamTwo().getTeamFPS())==1){
								this.victor = gameMatchUp.getTeamOne();
									gameMatchUp.getTeamOne().teamWon();
								this.loser = gameMatchUp.getTeamTwo();
									gameMatchUp.getTeamTwo().teamLost();
									
								System.out.println(this.getVictor().printStats());
								System.out.println(this.getLoser().printStats());
							}
			
						// Draw
							else
								System.out.println("This Game Resulted in a Draw");

			}
						
/***************************************************************************************/
/********** PRINT METHODS **************************************************************/
/***************************************************************************************/

	// Game Print Methods
			
			// Game toString
				@Override
				public String toString() {
					return "Game [gameMatchUp=" + gameMatchUp + ", victor=" + victor + ", loser=" + loser + "]";
				}
				
			// Game Results
				public String printGameResults() {
					return this.gameMatchUp.toString() + "\n" + this.getVictor().printStats()+ "\n" + this.getLoser().printStats();
				}			
				
}				
