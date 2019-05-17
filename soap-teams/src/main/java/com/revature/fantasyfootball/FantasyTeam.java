package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;

// Create Team Object
public class FantasyTeam {

	// Fantasy Team Fields
		// Team SERIAL ID
		private int teamID;
		// Team Name
		private String teamName;
		// Team Rank
		private int teamRank;
		// Team Fantasy Point Statistic
		private BigDecimal teamFPS;
		// Team Number Of Wins
		private int teamWins;
		// Team Number Of Losses
		private int teamLoss;
		// Record Of Teams Played
		ArrayList<String> playedTeams = new ArrayList<>();
		
	// Fantasy Team Getters and Setters
		public int getTeamID() {
			return teamID;
		}
		public void setTeamID(int teamID) {
			this.teamID = teamID;
		}
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		public int getTeamRank() {
			return teamRank;
		}
		public void setTeamRank(int teamRank) {
			this.teamRank = teamRank;
		}
		public BigDecimal getTeamFPS() {
			return teamFPS;
		}
		public void setTeamFPS(BigDecimal teamFPS) {
			this.teamFPS = teamFPS;
		}
		public int getTeamWins() {
			return teamWins;
		}
		public void setTeamWins(int teamWins) {
			this.teamWins = teamWins;
		}
		public int getTeamLoss() {
			return teamLoss;
		}
		public void setTeamLoss(int teamLoss) {
			this.teamLoss = teamLoss;
		}
	
	// Increment Team Wins
		public void teamHasWon() {
			this.teamWins++;
		}
	
	// Increment Team Loss
		public void teamHasLoss() {
			this.teamLoss++;
		}
		
	// OverWrite toString
		public String toString() {
			return "\nTeam " + teamRank + ": " + teamName;
		}

}
