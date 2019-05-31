package com.revature.fantasyfootball2;

import java.util.ArrayList;

import javax.jws.WebParam;

public class TestWeekSimulationClass {

	public FantasyLeague simWeekFunction(ArrayList<TeamResult> teamResults, FantasyLeague weekTestLeague, ArrayList<MatchUp> seasonMatchUps, int weekNumber) {
		
		System.out.println("Week Number : " + weekNumber);
		// Assign FPS
		for(TeamResult result:teamResults){
			for(FantasyTeam team: weekTestLeague.getTeams()) {
				if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
					team.setTeamFPS(result.getTeamFPS());
				}
			}
		}
	
			TestRunGameClass test = new TestRunGameClass();
			test.testingRunGameFunction(seasonMatchUps, weekTestLeague);
			test.testingRunGameFunction(seasonMatchUps, weekTestLeague);
			test.testingRunGameFunction(seasonMatchUps, weekTestLeague);
		
		return weekTestLeague;
	}
}
