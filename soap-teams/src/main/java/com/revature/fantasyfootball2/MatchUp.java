package com.revature.fantasyfootball2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
/*********************************************** MATCH UP FUNCTIONS ****************************************************************/
/*******************************************************************************************************************************************/	
	
	// Match Up Functions
			
		// Select Teams For Match Up
			// selects random team
				public void setMatchUp(ArrayList<FantasyTeam> availableTeamsForMatch, int weekNumber, int gameNumber) {
					// Method Fields
					
						// Game One
					
						if(weekNumber==1 && gameNumber == 1) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Gordon Flashes"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Majal Towers"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==2 && gameNumber == 1) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Gordon Flashes"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Andres Tiburones"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==3 && gameNumber == 1) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Gordon Flashes"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Khalifa Cheebas"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==4 && gameNumber == 1) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Gordon Flashes"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Dillon Dillos"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==5 && gameNumber == 1) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Gordon Flashes"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Revature Ravagers"))
									this.teamTwo = team;
							}
						}
						
						// Game Two
						
						if(weekNumber==1 && gameNumber == 2) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Dillon Dillos"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Andres Tiburones"))
									this.teamTwo = team;
								
							}
						}
						if(weekNumber==2 && gameNumber == 2) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Dillon Dillos"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Revature Ravagers"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==3 && gameNumber == 2) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Dillon Dillos"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Majal Towers"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==4 && gameNumber == 2) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Andres Tiburones"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Khalifa Cheebas"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==5 && gameNumber == 2) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Dillon Dillos"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Khalifa Cheebas"))
									this.teamTwo = team;
							}
						}
						
						// Game Three
						
						if(weekNumber==1 && gameNumber == 3) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Khalifa Cheebas"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Revature Ravagers"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==2 && gameNumber == 3) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Majal Towers"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Khalifa Cheebas"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==3 && gameNumber == 3) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Revature Ravagers"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Andres Tiburones"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==4 && gameNumber == 3) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Majal Towers"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Andres Tiburones"))
									this.teamTwo = team;
							}
						}
						if(weekNumber==5 && gameNumber == 3) {
							for(FantasyTeam team: availableTeamsForMatch) {
								if(team.getTeamName().equalsIgnoreCase("Revature Ravagers"))
									this.teamOne = team;
								if(team.getTeamName().equalsIgnoreCase("Majal Towers"))
									this.teamTwo = team;
							}
						}
							
							
						
				}		
			
/*******************************************************************************************************************************************/
/*********************************************** MATCH UP DISPLAY FUNCTIONS ****************************************************************/
/*******************************************************************************************************************************************/

	// Match Up Print Functions
	
		// OverWrite toString
			@Override
			public String toString() {
				return  teamOne.printTeamName() +" vs. "+ teamTwo.printTeamName() + "\n";
			}
			public void printMatchUp() {
				
				System.out.println(teamOne.getTeamName()+": " + teamOne.getTeamFPS() + " vs. " + teamTwo.getTeamName()+ ": " + teamTwo.getTeamFPS());
			}
			public void setMatchUp(ArrayList<FantasyTeam> teams, int numberOfTeams, ArrayList<MatchUp> seasonMatchUps) {
				// TODO Auto-generated method stub
				
			}
			public void setMatchUp(ArrayList<FantasyTeam> teams, int size, ArrayList<MatchUp> seasonMatchUps) {
				// TODO Auto-generated method stub
				
			}
}