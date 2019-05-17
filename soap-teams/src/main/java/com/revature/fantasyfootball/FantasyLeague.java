package com.revature.fantasyfootball;

import java.util.ArrayList;

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
			return "FantasyLeague " + teams ;
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
}
