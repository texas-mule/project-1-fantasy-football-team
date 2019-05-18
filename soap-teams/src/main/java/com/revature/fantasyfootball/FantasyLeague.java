package com.revature.fantasyfootball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Creates Fantasy League
public class FantasyLeague {
	
	// Fantasy League Fields
		// Number of Teams
		private int numberOfTeams;
		// Teams
		 private ArrayList<FantasyTeam> teams = new ArrayList<>();
		
	// Populate League With Teams
		public void setLeague() {
			// Instantiate DataConnection
			DataConnect createFantasyLeague = new DataConnect();
			
			// Populate League
			teams = createFantasyLeague.retrieveLeagueInformation();
			numberOfTeams= createFantasyLeague.getTeamCounter();
		}

		@Override
		public String toString() {
			Comparator<FantasyTeam> displayLeagueByRank =Comparator.comparing(FantasyTeam::getTeamRank);  
			 Collections.sort(teams,displayLeagueByRank);  
			return " " + teams ;
		}

		public int getNumberOfTeams() {
			return numberOfTeams;
		}

		public void setNumberOfTeams(int numberOfTeams) {
			this.numberOfTeams = numberOfTeams;
		}

		public ArrayList<FantasyTeam> getTeams() {
			return teams;
		}
		
		public ArrayList<FantasyTeam> updateLeagueRanks() {
			 Comparator<FantasyTeam> updateRank =Comparator.comparing(FantasyTeam::getTeamWins);  
			 Collections.sort(teams,updateRank);  
			    int i=6;
			    for(FantasyTeam team: teams){ 
			    	team.setTeamRank(i--);  
			      }   
			return teams;
		}
}
