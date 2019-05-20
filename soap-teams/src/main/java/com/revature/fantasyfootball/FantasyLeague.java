package com.revature.fantasyfootball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Creates Object To Represent A League
public class FantasyLeague {

/*******************************************************************************************************************************************/
/**************************************************** FANTASY LEAGUE FIELDS ****************************************************************/
/*******************************************************************************************************************************************/
	
	// Fantasy League Fields
	
		// Teams
			private ArrayList<FantasyTeam> teams = new ArrayList<>();
			
		// Number of Teams
			private int numberOfTeams;
			
		// Instantiate DataConnection To Gather League Data
			DataConnect leagueDataConnection = new DataConnect();

/*******************************************************************************************************************************************/
/********************************************* FANTASY LEAGUE GETTERS ANDS SETTERS *********************************************************/
/*******************************************************************************************************************************************/	

	// Fantasy League Getters and Setters
		
		// Teams
			public ArrayList<FantasyTeam> getTeams() {
				return teams;
			}
			
			public void setTeams(ArrayList<FantasyTeam> teams) {
					this.teams = teams;
			}

		// Number Of Teams
			public int getNumberOfTeams() {
				return numberOfTeams;
			}

			public void setNumberOfTeams(int numberOfTeams) {
				this.numberOfTeams = numberOfTeams;
			}			

/*******************************************************************************************************************************************/
/********************************************** FANTASY LEAGUE FUNCTIONS *******************************************************************/
/*******************************************************************************************************************************************/

	// Fantasy League Functions
			
		// Set League
		// populates the league with teams
			public void setLeague() {
				// Gathers Teams in League
					this.leagueDataConnection.retrieveLeagueInformation();
					this.setTeams(leagueDataConnection.getFantasyLeagueInformation());
					
				
				// Counts Number of Teams
					this.numberOfTeams = teams.size();
			}

		// Update League bye Rank
		// sorts the league by number of wins and assigns a rank
			public ArrayList<FantasyTeam> updateLeagueRanks() {
				 Comparator<FantasyTeam> sortByWins =Comparator.comparing(FantasyTeam::getTeamWins);  
				 Collections.sort(teams,sortByWins);  
				    int i=6;
				    for(FantasyTeam team: teams){ 
				    	team.setTeamRank(i--);  
				      }   
				return teams;
			}
			
		// Submit League
		// at the end of the week, updates league in database
			public void endSimulation(FantasyLeague endOfWeekLeagueSubmission) {
				this.leagueDataConnection.updateLeagueInformation(endOfWeekLeagueSubmission);;		
			}
/*******************************************************************************************************************************************/
/******************************************** FANTASY LEAGUE DISPLAY FUNCTIONS *************************************************************/
/*******************************************************************************************************************************************/

	// Fantasy League Print Functions
		
		// OverWrite toString
		// print league as is
		@Override
			public String toString() {
				return " " + teams ;
			}
		
		// Display Teams By ID
		// print league by id
			public String displayTeamsByID() {
				Comparator<FantasyTeam> sortByID =Comparator.comparing(FantasyTeam::getTeamID);  
				Collections.sort(teams,sortByID);  
				return " " + teams ;
			}
			
		// Display Teams By Name
		// print league by alphabetical name
			public String displayTeamsByName() {
				Comparator<FantasyTeam> sortByName =Comparator.comparing(FantasyTeam::getTeamName);  
				Collections.sort(teams,sortByName);  
				return " " + teams ;
			}	
			
		// Display Teams By FPS
		// print league by FPS
			public String displayTeamsByFPS() {
				Comparator<FantasyTeam> sortByName =Comparator.comparing(FantasyTeam::getTeamFPS);  
				Collections.sort(teams,sortByName);  
				return " " + teams ;
			}
				
		// Display Teams
		// print league by alphabetical name
			public void displayTeamsByWins() {
				Comparator<FantasyTeam> sortByName =Comparator.comparing(FantasyTeam:: getWlDifference);  
				Collections.sort(teams,sortByName);
				Collections.reverse(teams);
				
				for(FantasyTeam printByWinTeam: teams) {
//					if(printByWinTeam.getTeamName().equalsIgnoreCase("Gordon Flashes")|| printByWinTeam.getTeamName().equalsIgnoreCase("Majal Towers") || printByWinTeam.getTeamName().equalsIgnoreCase("Dillon Dillos"))
//						System.out.println(printByWinTeam.getTeamName() + " 		Wins : " + printByWinTeam.getTeamWins() + " Losses : " + printByWinTeam.getTeamLoss());
//					else
						//System.out.println(printByWinTeam.getTeamName() + " 	Wins : " + printByWinTeam.getTeamWins() + " Losses : " + printByWinTeam.getTeamLoss());
				System.out.println(printByWinTeam.getTeamName() + " " + printByWinTeam.getWlDifference());
				}
			}
			public void displayTeamsByWinsStats() {
				Comparator<FantasyTeam> sortByName =Comparator.comparing(FantasyTeam:: getWlDifference);  
				Collections.sort(teams,sortByName);
				Collections.reverse(teams);
				
				for(FantasyTeam printByWinTeam: teams) {
//					if(printByWinTeam.getTeamName().equalsIgnoreCase("Gordon Flashes")|| printByWinTeam.getTeamName().equalsIgnoreCase("Majal Towers") || printByWinTeam.getTeamName().equalsIgnoreCase("Dillon Dillos"))
//						System.out.println(printByWinTeam.getTeamName() + " 		Wins : " + printByWinTeam.getTeamWins() + " Losses : " + printByWinTeam.getTeamLoss());
//					else
						//System.out.println(printByWinTeam.getTeamName() + " 	Wins : " + printByWinTeam.getTeamWins() + " Losses : " + printByWinTeam.getTeamLoss());
				System.out.println(printByWinTeam.getTeamName() + " Wins :  " + printByWinTeam.getTeamWins() + "  Losses : " + printByWinTeam.getTeamLoss());
				}
			}
}
