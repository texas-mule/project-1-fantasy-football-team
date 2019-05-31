package com.revature.fantasyfootball.league;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.revature.fantasyfootball.database.DatabaseAccess;

// Create An Object To Represent A League
public class League {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/
	
	// League Fields
	
		// League Name
			private String leagueName;
			
		// Collection Of Teams
			private ArrayList<Team> teams = new ArrayList<Team>();
			
		// League Leader
			private Team leagueLeader;
			
		// Week Number
			private int week;
			
		// Season Number
			private int season;

/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/
	
	// League Getters and Setters
			
			// League Name
				public String getLeagueName() {
					return leagueName;
				}
	
				public void setLeagueName(String leagueName) {
					this.leagueName = leagueName;
				}
			
			// Teams
				public ArrayList<Team> getTeams() {
					return teams;
				}
	
				public void setTeams(ArrayList<Team> teams) {
					this.teams = teams;
				}

			// League Leader
				public Team getLeagueLeader() {
					return leagueLeader;
				}
	
				public void setLeagueLeader(Team leagueLeader) {
				this.leagueLeader = leagueLeader;
			}

			// Week
				public int getWeek() {
					return week;
				}
	
				public void setWeek(int week) {
					this.week = week;
				}

			// Season
				public int getSeason() {
					return season;
				}
	
				public void setSeason(int season) {
				this.season = season;
			}		
			
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/
				
	// League Methods
				
		// Create New League
				public void createLeague(String newLeagueName, ArrayList<String> teamNames, League newLeague) {
					
					// Initialize DAO
						DatabaseAccess createAccess = new DatabaseAccess();
					
					// Implement DAO
						createAccess.createLeagueTable(newLeagueName, teamNames, newLeague);
				}
				
		// Start Season
				public void initLeague(League league) {
					
					// Initialize DAO
						DatabaseAccess readAccess = new DatabaseAccess();
						
					// Implement DAO
						readAccess.readLeague(league);
						
				}
				
		// Update League Ranking
				public void updateRanking(League league) {
					 Comparator<Team> sortByWLRatio =Comparator.comparing(Team::getTeamWLRatio);  
					 Collections.sort(league.getTeams(),sortByWLRatio);  
					    int i= league.getTeams().size();
					    for(Team team: league.getTeams()){ 
					    	team.setTeamRank(i--);  
					      }   
				}
				
		// End Season
				public void finalizeLeague(League league) {
					
					// Initialize DAO
						DatabaseAccess finalizeAccess = new DatabaseAccess();
						
					// Implement DAO
						System.out.println(league.getTeams().toString());
						finalizeAccess.updateLeague(league);
					
				}
}
