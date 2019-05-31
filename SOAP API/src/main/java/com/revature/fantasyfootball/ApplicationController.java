package com.revature.fantasyfootball;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;
import com.revature.fantasyfootball.simulation.Game;
import com.revature.fantasyfootball.simulation.Season;
import com.revature.fantasyfootball.simulation.TeamResult;
import com.revature.fantasyfootball.simulation.Week;


@WebService
 public class ApplicationController {
	
	int year = 2019;
	int week = 0;
	
	@WebMethod
	public League simGame(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
		
		// Parameters
		
			// League
				League league = new League();
				league.setLeagueName("league");
				league.initLeague(league);
		
			// Results
				for(TeamResult result:teamResults){
					for(Team team: league.getTeams()) {
						if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
							team.setTeamFPS(result.getTeamFPS());
						}
					}
				}
		
			// Game
				Game game = new Game();

		// Implementations
				
			// Run Game
				game.runGame(league);
		
			// Update Rankings
				league.updateRanking(league);
		
			// Update Database
				league.finalizeLeague(league);
		
		return league;	
	}
	
	@WebMethod
	public League simWeek(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
		
		// Parameters
		
			// League
				League league = new League();
				league.setLeagueName("league");
				league.setSeason(year);
				league.setWeek(week);
				league.initLeague(league);
		
			// Results
				for(TeamResult result:teamResults){
					for(Team team: league.getTeams()) {
						if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
							team.setTeamFPS(result.getTeamFPS());
						}
					}
				}
		
			// Week
				Week weekSim = new Week();

		// Implementations
				
			// Simulate Week
				weekSim.runWeek(league, week);
		
			// Update Rankings
				league.updateRanking(league);
		
			// Update Database
				league.finalizeLeague(league);
				week++;
		
		return league;	
	}
	
	@WebMethod
	public League simSeason(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
		
		// Parameters
		
			// League
				League league = new League();
				league.setLeagueName("league");
				league.setSeason(year);
				league.setWeek(week);
				league.initLeague(league);
		
			// Results
				for(TeamResult result:teamResults){
					for(Team team: league.getTeams()) {
						if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
							team.setTeamFPS(result.getTeamFPS());
						}
					}
				}
		
			// Season
				Season seasonSim = new Season();

		// Implementations
				
			// Simulate Season
				seasonSim.runSeason(league, year, week);
		
			// Update Rankings
				league.updateRanking(league);
		
			// Update Database
				league.finalizeLeague(league);
				year++;
		
		return league;	
	}

}