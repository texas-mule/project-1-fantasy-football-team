package com.revature.fantasyfootball2;

import java.math.BigDecimal;

// Create An Object To Represent A Team
public class Team {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/
	
	// Fantasy Team Fields
	
		// Team Serial ID
			private int teamID;
			
		// Team Name
			private String teamName;
			
		// Team Rank
			private int teamRank;
			
		// Team Fantasy Point Statistic
			private BigDecimal teamFPS;
			
		// Team Wins
			private int teamWinStat;
			
		// Team Losses
			private int teamLossStat;
			
		// Team Win - Loss Ratio
			private int teamWLRatio;

		
			
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/
			
	// Team Getters and Setters
			
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

			// Team Fantasy Point Statistic
				public BigDecimal getTeamFPS() {
					return teamFPS;
				}
	
				public void setTeamFPS(BigDecimal teamFPS) {
				this.teamFPS = teamFPS;
			}

			// Team Wins
				public int getTeamWinStat() {
					return teamWinStat;
				}
	
				public void setTeamWinStat(int teamWinStat) {
				this.teamWinStat = teamWinStat;
			}

			// Team Losses
				public int getTeamLossStat() {
					return teamLossStat;
				}
	
				public void setTeamLossStat(int teamLossStat) {
				this.teamLossStat = teamLossStat;
			}

			// Team Win - Loss Ratio
				public int getTeamWLRatio() {
					return teamWLRatio;
				}
	
				public void setTeamWLRatio(int teamWLRatio) {
				this.teamWLRatio = teamWLRatio;
			}

		
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/
			
	// Team Methods
				
		// Team Has Won A Game
			public void teamWon() {
				this.teamWinStat++;
				this.teamWLRatio = (this.teamWinStat - this.teamLossStat);
				System.out.println("\n-" + this.teamName + "_WON_A_GAME-");
			}
			
		// Team Has Lost A Game
			public void teamLost() {
				this.teamLossStat++;
				this.teamWLRatio = (this.teamWinStat - this.teamLossStat);
				System.out.println("\n-" + this.teamName + "_LOST_A_GAME-");
			}
			

			
/***************************************************************************************/
/********** PRINT METHODS **************************************************************/
/***************************************************************************************/

	// Team Print Methods
				
		// Team toString();
			@Override
			public String toString() {
				return "Team " + teamID + " : teamName= " + teamName 
						+ "\n	 teamRank = " + teamRank 
						+ "\n	 teamFPS = "  + teamFPS 
						+ "\n	 teamWinStat = "  + teamWinStat 
						+ "\n	 teamLossStat = " + teamLossStat
						+ "\n	 teamWLRatio = "  + teamWLRatio + "]";
			}
			
		// Print Team Name
			public String printName() {
				return teamName;
			}
			
		// Print Team Stats
			public String printStats() {
				return teamName + " " + teamWinStat + " " + teamLossStat;
			}
			
		// Print Team FPS
			public String printFPS() {
				return teamName + " " + teamFPS;
			}
			
}
