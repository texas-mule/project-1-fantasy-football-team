package com.revature.fantasyfootball.simulation;

import java.util.ArrayList;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;

// Create An Object To Represent A Week
public class Week {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Week Fields
	
		// Week Victors
			ArrayList<Team> weekVictors = new ArrayList<Team>();
	
		// Week Losers
			ArrayList<Team> weekLosers = new ArrayList<Team>();
			
		// Number Of Games
			int numberOfGames;
			
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/

	// Week Getters and Setters
			
			// This Week Victors
				public ArrayList<Team> getWeekVictors() {
					return weekVictors;
				}
				public void setWeekVictors(ArrayList<Team> weekVictors) {
					this.weekVictors = weekVictors;
				}	
				
			// This Week Losers
				public ArrayList<Team> getWeekLosers() {
					return weekLosers;
				}
				public void setWeekLosers(ArrayList<Team> weekLosers) {
					this.weekLosers = weekLosers;
				}
				
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/
	
	// Week Methods
				
		// Run A Week
			public void runWeek(League league, int week) {
				
				// Parameters
					numberOfGames = (league.getTeams().size()/2);
					System.out.println(numberOfGames);
					
				for(int iteration = 1; iteration<=numberOfGames;iteration++) {
					Game game = new Game();
					
					game.runGame(league);
					
					weekVictors.add(game.getVictor());
					weekLosers.add(game.getLoser());
				}
				
				week++;
				league.setWeek(week);
				System.out.println("WEEK " + week);
			}
						
/***************************************************************************************/
/********** PRINT METHODS **************************************************************/
/***************************************************************************************/

	// Week Print Methods
			
			// Week toString
				@Override
				public String toString() {
					return "Week [weekVictors=" + weekVictors + ", weekLosers=" + weekLosers + ", numberOfGames=" + numberOfGames + "]";
				}
				
			// Week Results
				public String printWeekResults() {
					return "\nWeekly Results : " + this.getWeekVictors() + "\n" + this.getWeekLosers();
				}
			
				
}				
