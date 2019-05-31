package com.revature.fantasyfootball.simulation;

import java.util.Collections;
import java.util.Comparator;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;

// Create An Object To Represent A Week
public class Season {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/

	// Season Fields
	
		// Season Year
			long seasonYear;
			
		// Number Of Weeks
			int numberOfWeeks;
			
		// Champion
			Team seasonChampion;
			
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/

	// Season Getters and Setters
			
			// Season Year
				public long getSeasonYear() {
					return seasonYear;
				}
	
				public void setSeasonYear(long seasonYear) {
					this.seasonYear = seasonYear;
				}

			// Number Of Weeks
				public int getNumberOfWeeks() {
					return numberOfWeeks;
				}
	
				public void setNumberOfWeeks(int numberOfWeeks) {
					this.numberOfWeeks = numberOfWeeks;
				}

			// Season Champion
				public Team getSeasonChampion() {
					return seasonChampion;
				}
	
				public void setSeasonChampion(Team seasonChampion) {
					this.seasonChampion = seasonChampion;
				}
				
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/
	
	// Season Methods
				
		// Run A Week
			public void runSeason(League league,int year, int week) {
				
				// Parameters
					numberOfWeeks = weekCalculator(league);
					System.out.println(numberOfWeeks);
					
				for(int iteration = 1; iteration<=numberOfWeeks;iteration++) {
					Week weekSim = new Week();
					
					weekSim.runWeek(league, week);
					
					sortTeamsByWinsStats(league);
					
					league.setLeagueLeader(league.getTeams().get(0));
					
					this.seasonChampion = league.getLeagueLeader();
					week++;
					league.setWeek(week);
				}
				year++;
				league.setSeason(year);
			}
			
			public int weekCalculator(League league) {
				
				int numerator = factorial(league.getTeams().size());
				
				int firstDenominator = factorial(2);
				
				int secondDenominator = factorial(league.getTeams().size()-2);
				
				int total = numerator / (firstDenominator*secondDenominator);
				
				return total /(league.getTeams().size()/2);
			}
			
			public int factorial(int n){
				  if (n == 0)    
					    return 1;    
				  else    
					    return(n * factorial(n-1));    
			}
			
			public void sortTeamsByWinsStats(League league) {
				Comparator<Team> sortByWL =Comparator.comparingInt(Team::getTeamWLRatio);  
				Collections.sort(league.getTeams(),sortByWL);
				Collections.reverse(league.getTeams());
			}

				
/***************************************************************************************/
/********** PRINT METHODS **************************************************************/
/***************************************************************************************/

	// Season Print Methods
			
			// Season toString();
			@Override
			public String toString() {
				return "Season [seasonYear=" + seasonYear + ", numberOfWeeks=" + numberOfWeeks + ", seasonChampion="
						+ seasonChampion + "]";
			}
				
			


			
				
}		