package com.revature.fantasyfootball;

import java.math.BigDecimal;

<<<<<<< HEAD
public class fantasyTeam {
=======
class fantasyTeam {
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
	
	private int teamIndicator;
	private String teamName;
	private int teamRank;
<<<<<<< HEAD
	private BigDecimal teamFPS;
	
=======
	private int teamWins;
	private int teamLoss;
	private BigDecimal teamFPS;
	
	
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
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
	public int getTeamIndicator() {
		return teamIndicator;
	}
	public void setTeamIndicator(int teamIndicator) {
		this.teamIndicator = teamIndicator;
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
	
<<<<<<< HEAD
=======
	public void teamHasWon() {
		this.teamWins++;
	}
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
}
