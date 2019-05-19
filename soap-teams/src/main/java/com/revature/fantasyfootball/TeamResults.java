package com.revature.fantasyfootball;

import java.math.BigDecimal;

public class TeamResults {

	String teamName;
	BigDecimal teamFPS;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public BigDecimal getTeamFPS() {
		return teamFPS;
	}
	public void setTeamFPS(BigDecimal teamFPS) {
		this.teamFPS = teamFPS;
	}
	
}
