package com.revature.fantasyfootball2;

import java.util.ArrayList;
import java.util.Iterator;

// Create A Week
public class Week {

/*******************************************************************************************************************************************/
/********************************************************* WEEK FIELDS *********************************************************************/
/*******************************************************************************************************************************************/
	// Week Fields
		// Game One
			private Game GameOne = new Game();
		// Game Two
			private Game GameTwo = new Game();
		// Game Three
			private Game GameThree = new Game();
		// League Post Week Simulation
			private FantasyLeague leagueOutput = new FantasyLeague();
		// Create Array of Weekly MatchUps
			ArrayList<MatchUp> selectedWeeklyMatchUps = new ArrayList<>();
		// Week Victors
			ArrayList<FantasyTeam> weeklyVictors = new ArrayList<FantasyTeam>();
		// Week Victors
			ArrayList<FantasyTeam> weeklyLosers = new ArrayList<FantasyTeam>();
			
/*******************************************************************************************************************************************/
/*********************************************** WEEK GETTERS ANDS SETTERS *****************************************************************/
/*******************************************************************************************************************************************/	
	// Week Getters and Setters
		// Game One
			public Game getGameOne() {
				return GameOne;
			}
			public void setGameOne(Game gameOne) {
				GameOne = gameOne;
			}		
		// Game Two
			public Game getGameTwo() {
				return GameTwo;
			}
			public void setGameTwo(Game gameTwo) {
				GameTwo = gameTwo;
			}		
		// Game Three
			public Game getGameThree() {
				return GameThree;
			}
			public void setGameThree(Game gameThree) {
				GameThree = gameThree;
			}		
		// League Following Simulation
			public FantasyLeague getLeagueOutput() {
				return leagueOutput;
			}
			public void setLeagueOutput(FantasyLeague leagueOutput) {
				this.leagueOutput = leagueOutput;
			}		
	
		// Selected Match Ups This Week
			public ArrayList<MatchUp> getSelectedWeeklyMatchUps() {
				return selectedWeeklyMatchUps;
			}
			public void setSelectedWeeklyMatchUps(ArrayList<MatchUp> selectedWeeklyMatchUps) {
				this.selectedWeeklyMatchUps = selectedWeeklyMatchUps;
			}
		// This Week Winners
			public ArrayList<FantasyTeam> getWeeklyVictors() {
				return weeklyVictors;
			}
			public void setWeeklyVictors(ArrayList<FantasyTeam> weeklyVictors) {
				this.weeklyVictors = weeklyVictors;
			}		
		// This Week Losers
			public ArrayList<FantasyTeam> getWeeklyLosers() {
				return weeklyLosers;
			}
			public void setWeeklyLosers(ArrayList<FantasyTeam> weeklyLosers) {
				this.weeklyLosers = weeklyLosers;
			}
			
/*******************************************************************************************************************************************/
/************************************************* WEEK FUNCTIONS **************************************************************************/
/*******************************************************************************************************************************************/
		
//	// Week Functions
//			
//			// Simulate Week
//			// simulates three games to represent an entire week
//			
//				public FantasyLeague simWeek(FantasyLeague leagueInput, ArrayList<MatchUp> seasonSelectedMatchUps) {
//					
//					// Method Fields
//					
//						// Return League
//							FantasyLeague endOfWeekLeague = new FantasyLeague();
//					
//						// League Input
//							int numberOfTeams = leagueInput.getNumberOfTeams();
//						
//						// Game One
//							System.out.println("GAME ONE");
//							selectedWeeklyMatchUps.add(GameOne.setGame(availableTeamsForWeekMatchups, numberOfTeams, seasonSelectedMatchUps));
//							System.out.println(GameOne.getGameMatchUp());
//							System.out.println(GameOne.getGameVictor());
//							numberOfTeams--;
//							numberOfTeams--;
//							
//							System.out.println();
//							
//						// Game Two
//							System.out.println("GAME TWO");
//							selectedWeeklyMatchUps.add(GameTwo.setGame(availableTeamsForWeekMatchups, numberOfTeams, seasonSelectedMatchUps));
//							System.out.println(GameTwo.getGameMatchUp());
//							System.out.println(GameTwo.getGameVictor());
//							availableTeamsForWeekMatchups.remove(GameTwo.getGameVictor());
//							numberOfTeams--;
//							availableTeamsForWeekMatchups.remove(GameTwo.getGameLoser());
//							numberOfTeams--;
//							
//							System.out.println();
//							
//						// Game Three
//							System.out.println("GAME THREE");
//							selectedWeeklyMatchUps.add(GameThree.setGame(availableTeamsForWeekMatchups, numberOfTeams, seasonSelectedMatchUps));
//							System.out.println(GameThree.getGameMatchUp());
//							System.out.println(GameThree.getGameVictor());
//
//							System.out.println();
//						
//							seasonSelectedMatchUps.addAll(selectedWeeklyMatchUps);
//							
//							endOfWeekLeague.setTeams(leagueInput.getTeams());
//						
//					return endOfWeekLeague;
//				}
}
