package com.revature.fantasyfootball;

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
			int gameNumber = 1;
			test.testingRunGameFunction(weekTestLeague, weekNumber, gameNumber);
			gameNumber = 2;
			test.testingRunGameFunction(weekTestLeague,weekNumber,  gameNumber);
			gameNumber = 3;
			test.testingRunGameFunction(weekTestLeague,weekNumber,  gameNumber);
		
		return weekTestLeague;
	}
}
