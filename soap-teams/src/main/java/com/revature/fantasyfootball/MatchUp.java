package com.revature.fantasyfootball;

// Create An Object To Represent Team Match Ups
public class MatchUp {

/*******************************************************************************************************************************************/
/******************************************************* MATCH UP FIELDS *******************************************************************/
/*******************************************************************************************************************************************/

	// MatchUp Fields
	
		// Team One
			FantasyTeam teamOne = new FantasyTeam();
			
		// Team Two
			FantasyTeam teamTwo = new FantasyTeam();
	
/*******************************************************************************************************************************************/
/*********************************************** MATCH UP GETTERS ANDS SETTERS *************************************************************/
/*******************************************************************************************************************************************/	
			
	// MatchUp Getters and Setters
		
		// Team One
			public FantasyTeam getTeamOne() {
				return teamOne;
			}
			
			public void setTeamOne(FantasyTeam teamOne) {
				this.teamOne = teamOne;
			}
		
		// Team Two
			public FantasyTeam getTeamTwo() {
				return teamTwo;
			}
			
			public void setTeamTwo(FantasyTeam teamTwo) {
				this.teamTwo = teamTwo;
			}
		
/*******************************************************************************************************************************************/
/*********************************************** MATCH UP DISPLAY FUNCTIONS ****************************************************************/
/*******************************************************************************************************************************************/

	// Match Up Print Functions
	
		// OverWrite toString
			@Override
			public String toString() {
				return  teamOne.printTeamName() +" vs. "+ teamTwo.printTeamName();
			}
			
			public String printMatchUp() {
				return  teamOne.printTeamName() +" vs. "+ teamTwo.printTeamName();
			}
}
