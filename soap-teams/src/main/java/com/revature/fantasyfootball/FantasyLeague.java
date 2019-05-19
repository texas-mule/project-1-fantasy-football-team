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
			DataConnect createFantasyLeague = new DataConnect();

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
				teams = createFantasyLeague.retrieveLeagueInformation();
				numberOfTeams= createFantasyLeague.getTeamCounter();
			}

		// Update League
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
			public void endSimulation(FantasyLeague myLeague) {
				createFantasyLeague.updateDataBaseInformation(myLeague);;		
			}
/*******************************************************************************************************************************************/
/******************************************** FANTASY LEAGUE DISPLAY FUNCTIONS *************************************************************/
/*******************************************************************************************************************************************/

	// Fantasy League Print Functions
		
		// OverWrite toString
		// print league by rank
		@Override
			public String toString() {
				Comparator<FantasyTeam> sortByRank =Comparator.comparing(FantasyTeam::getTeamRank);  
				Collections.sort(teams,sortByRank);  
				return " " + teams ;
			}
		
		// Display Teams
		// print league by id
			public String displayTeamsByID() {
				Comparator<FantasyTeam> sortByID =Comparator.comparing(FantasyTeam::getTeamID);  
				Collections.sort(teams,sortByID);  
				return " " + teams ;
			}
			
		// Display Teams
		// print league by alphabetical name
			public String displayTeamsByName() {
				Comparator<FantasyTeam> sortByName =Comparator.comparing(FantasyTeam::getTeamName);  
				Collections.sort(teams,sortByName);  
				return " " + teams ;
			}	
}
