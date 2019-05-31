package com.revature.fantasyfootball;

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
				public void setMatchUp(ArrayList<FantasyTeam> availableTeamsForMatch, int numberOfTeamsForMatch, ArrayList<MatchUp> previouslySelectedMatches) {
					System.out.println(" SETTING MATCH ");
					// Method Fields
					
						// Number of Teams to Select From
							int numberOfTeamsForMatchAttempt = numberOfTeamsForMatch;
							System.out.println(numberOfTeamsForMatchAttempt);
							
						// Available Teams to Select From
							ArrayList<FantasyTeam> availableTeamsForMatchAttempt = new ArrayList<FantasyTeam>();
							availableTeamsForMatchAttempt.addAll(availableTeamsForMatch);
							System.out.println(availableTeamsForMatchAttempt.size());
							
						// Iterator to scan through previous matches
							Iterator<MatchUp> scanPreviousMatches = previouslySelectedMatches.iterator();
							
						// Previous Matches
							MatchUp previousMatchUp = new MatchUp();
							
						// Random Integer
							Random randomSelector = new Random();
							
					// Method Implementation
							
						// Select Team One
							this.setTeamOne(availableTeamsForMatchAttempt.get(randomSelector.nextInt(numberOfTeamsForMatchAttempt)));
							availableTeamsForMatchAttempt.remove(this.teamOne);
							numberOfTeamsForMatchAttempt--;
							
						// Select Team Two
							this.setTeamTwo(availableTeamsForMatchAttempt.get(randomSelector.nextInt(numberOfTeamsForMatchAttempt)));
							availableTeamsForMatchAttempt.remove(this.teamTwo);
							numberOfTeamsForMatchAttempt--;
							
						// Check Match Up
							while(scanPreviousMatches.hasNext()) {
								
								// Scan through previous matchups	
									previousMatchUp = scanPreviousMatches.next();
								
								// Check MatchUp
									if(this.teamOne.getTeamName().equalsIgnoreCase(previousMatchUp.teamOne.getTeamName()) && this.teamTwo.getTeamName().equalsIgnoreCase(previousMatchUp.teamTwo.getTeamName())
									|| this.teamOne.getTeamName().equalsIgnoreCase(previousMatchUp.teamTwo.getTeamName()) && this.teamTwo.getTeamName().equalsIgnoreCase(previousMatchUp.teamOne.getTeamName())) {
										// Reselect
											setMatchUp(availableTeamsForMatch, numberOfTeamsForMatch, previouslySelectedMatches);	
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
			public String printMatchUp() {
				return  teamOne.printTeamName() +" vs. "+ teamTwo.printTeamName();
			}
}
