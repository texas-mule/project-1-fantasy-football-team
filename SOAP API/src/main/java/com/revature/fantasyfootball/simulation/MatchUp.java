package com.revature.fantasyfootball.simulation;

import java.util.Random;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;

// Create An Object To Represent A Team Match Up Selection
public class MatchUp {
	
/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Match Up Fields
	
		// Team One
			private Team teamOne;

		// Team Two
			private Team teamTwo;
			
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/
	
	// Match Up Getters and Setters	
			
		// Team One
			public Team getTeamOne() {
				return teamOne;
			}

			public void setTeamOne(Team teamOne) {
				this.teamOne = teamOne;
			}

		// Team Two
			public Team getTeamTwo() {
				return teamTwo;
			}

			public void setTeamTwo(Team teamTwo) {
				this.teamTwo = teamTwo;
			}

/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/

	// Match Up Methods		
				
		// Select Random Match Up
			public void selectMatchUp(League league) {
				
				// Parameters
						
					// Randomizer
						Random teamRandomizer = new Random();
						
					// Number of Available Teams For Randomizer
						int randomizerRange = league.getTeams().size();
						
				// Implementation
				
					// Select Team One
						this.setTeamOne(league.getTeams().get(teamRandomizer.nextInt(randomizerRange)));
						randomizerRange--;
						
					// Select Team Two
						this.setTeamTwo(league.getTeams().get(teamRandomizer.nextInt(randomizerRange)));
						
				// Checks
						
					// Unique Teams
						if(this.teamOne.getTeamName().equalsIgnoreCase(this.teamTwo.getTeamName()))
							selectMatchUp(league);
			}


				
/***************************************************************************************/
/********** PRINT METHODS **************************************************************/
/***************************************************************************************/
		
	// Match Up Print Methods
				
		// MatchUp toString();
				
			@Override
			public String toString() {
				return teamOne.printFPS() +" vs. "+ teamTwo.printFPS();
			}
}


