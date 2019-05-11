package com.revature.fantasyfootball;

import java.math.BigDecimal;

public class fantasyTeam {
	
	private int teamIndicator;
	private String teamName;
	private int teamRank;
	private BigDecimal teamFPS;
	
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
	
}
