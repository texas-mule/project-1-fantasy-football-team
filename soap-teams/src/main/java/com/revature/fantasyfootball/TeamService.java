package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
 public class TeamService {

	@WebMethod
	public void simSeason(BigDecimal team1FPS, BigDecimal team2FPS,BigDecimal team3FPS, BigDecimal team4FPS,BigDecimal team5FPS, BigDecimal team6FPS) {
		// Create Array of Season MatchUps
				ArrayList<MatchUp> seasonMatchUps = new ArrayList<>();
		// Create Array of Team FPS
				ArrayList<BigDecimal> teamFPS = new ArrayList<>();
					teamFPS.add(team1FPS);
					teamFPS.add(team2FPS);
					teamFPS.add(team3FPS);
					teamFPS.add(team4FPS);
					teamFPS.add(team5FPS);
					teamFPS.add(team6FPS);
				
				
		FantasyLeague myLeague = new FantasyLeague();
		myLeague.setLeague();
		
		int numberOfTeams = myLeague.getNumberOfTeams();
		
		for(int i = 0; i<numberOfTeams;i++) {
			myLeague.getTeams().get(i).setTeamFPS(teamFPS.get(i));
		}
	
		Week weekOne = new Week();
		seasonMatchUps.addAll(weekOne.simWeek(myLeague, numberOfTeams));
		System.out.println("This Week Match Ups");
		System.out.println(seasonMatchUps);
		System.out.println("-----------------------------");
		System.out.println("This Week Winners");
		System.out.println(weekOne.getVictors());
		
	}
}
