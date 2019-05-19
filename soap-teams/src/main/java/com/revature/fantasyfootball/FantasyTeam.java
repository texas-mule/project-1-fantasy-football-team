package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;

// Create Object To Represent A Team
public class FantasyTeam {

/*******************************************************************************************************************************************/
/**************************************************** FANTASY TEAM FIELDS ******************************************************************/
/*******************************************************************************************************************************************/
	
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
			
/*******************************************************************************************************************************************/
/********************************************* FANTASY TEAM GETTERS ANDS SETTERS ***********************************************************/
/*******************************************************************************************************************************************/	
			
	// Fantasy Team Getters and Setters
			
		// Team ID
			public int getTeamID() {
				return teamID;
			}
			public void setTeamID(int teamID) {
				this.teamID = teamID;
			}
			
		// Team Name
			public String getTeamName() {
				return teamName;
			}
			public void setTeamName(String teamName) {
				this.teamName = teamName;
			}
			
		// Team Rank
			public int getTeamRank() {
				return teamRank;
			}
			public void setTeamRank(int teamRank) {
				this.teamRank = teamRank;
			}
			
		// Team Fantasy Point
			public BigDecimal getTeamFPS() {
				return teamFPS;
			}
			public void setTeamFPS(BigDecimal teamFPS) {
				this.teamFPS = teamFPS;
			}
		
		// Team Wins
			public int getTeamWins() {
				return teamWins;
			}
			public void setTeamWins(int teamWins) {
				this.teamWins = teamWins;
			}
			
		// Team Losses
			public int getTeamLoss() {
				return teamLoss;
			}
			public void setTeamLoss(int teamLoss) {
				this.teamLoss = teamLoss;
			}

/*******************************************************************************************************************************************/
/********************************************** FANTASY TEAM FUNCTIONS *********************************************************************/
/*******************************************************************************************************************************************/
	
	// Team Functions
			
		// Team Has Won A Game
		// increments team wins field given the team wins a game	
			public void teamHasWon() {
				this.teamWins++;
			}
		
		// Team Has Lost A Game
		// increments team losses field given the team loses a game
			public void teamHasLoss() {
				this.teamLoss++;
			}
			
/*******************************************************************************************************************************************/
/******************************************** FANTASY TEAM DISPLAY FUNCTIONS ***************************************************************/
/*******************************************************************************************************************************************/
	
	// Team Print Functions
			
		// OverWrite toString
			public String toString() {
				String printStatement = printTeamInformation();
				return printStatement;
			}
		
		// Print Team Information
		// prints by team ID , team rank , team name , team wins , team losses
			public String printTeamInformation() {
				return "\nTeam " + teamID + ": " + teamName + "\n 	Team Rank : " + teamRank + "\n 	Team Win Stat : " + teamWins + "\n 	Team Loss Stat : " + teamLoss;
			}
			
		// Print Team Name
		// prints team name
			public String printTeamName() {
				return teamName;
			}
			
		// Print Team Stats
		// prints team wins and losses
				public String printTeamStats() {
					return teamName + " " + teamWins + " " + teamLoss;
				}
		
}
