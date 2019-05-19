package com.revature.fantasyfootball;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.*;

@WebService
 public class TeamService {
	
/*******************************************************************************************************************************************/
/********************************************************* SERVICE FIELDS *********************************************************************/
/*******************************************************************************************************************************************/

	// Team Service Fields
	
		// Week Count
			int weekNumber = 0;

		// Season Match Ups Array List
			ArrayList<MatchUp> seasonMatchUps = new ArrayList<>();


/*******************************************************************************************************************************************/
/*********************************************** SERVICE GETTERS ANDS SETTERS *****************************************************************/
/*******************************************************************************************************************************************/	

	// Team Service Getters and Setters
			public ArrayList<MatchUp> getSeasonMatchUps() {
				return seasonMatchUps;
			}

/*******************************************************************************************************************************************/
/************************************************* SERVICE FUNCTIONS **************************************************************************/
/*******************************************************************************************************************************************/
			@WebMethod
			public FantasyLeague simWeekFunction(@WebParam(name = "team", partName = "teamName") ArrayList<TeamResults> teamResults) {
				System.out.println(" INPUT ");
				for(TeamResults r:teamResults)
				{
					System.out.println(r.teamName);
					System.out.println(r.teampFPS);
					
				}
				
				// Method Fields
					
					// Input League
						FantasyLeague beginningWeekLeague = new FantasyLeague();
						beginningWeekLeague.setLeague();
					
					// Output League
						FantasyLeague endingWeekLeague = new FantasyLeague();
						endingWeekLeague.setLeague();
						
					// Current Week 		
						System.out.println("------------------------------- \n");
						System.out.println("Week Number : " + weekNumber);
						Week thisWeek = new Week();
					
					// Team Results
						ArrayList<TeamResults> teamFPS = new ArrayList<TeamResults>();
						teamFPS.addAll(teamResults);
					
				// Method Implementation
							System.out.println(teamFPS.size());
							// Updates League Given Previous Week
							endingWeekLeague = thisWeek.simWeek(beginningWeekLeague, seasonMatchUps, teamFPS);
							System.out.println(endingWeekLeague.displayTeamsByWins());
			
				seasonMatchUps.addAll(thisWeek.selectedWeeklyMatchUps);
				
				weekNumber++;
				endingWeekLeague.setNumberOfTeams(endingWeekLeague.getTeams().size());

				endingWeekLeague.endSimulation(endingWeekLeague);
				
				return endingWeekLeague;
			}
			
			public ArrayList<TeamResults> testingTestResults(){
				ArrayList<TeamResults> teamResults = new ArrayList<TeamResults>();
				setTestTeamFPS(teamResults);
				return teamResults;
			}
			
/*******************************************************************************************************************************************/
/************************************************* SERVICE TEST FUNCTIONS ******************************************************************/
/*******************************************************************************************************************************************/

// Team Service Test Functions
				
	// Testing Game Selection Method
	// tests the method which sets up games
	@WebMethod
		public void testingMatchSelectionFunction() {
							
		// Testing Game Fields	
								
		for(int i =0;i<15;i++) {
			
			// Match Up Return
				MatchUp match = new MatchUp();
			
			// Previously Selected Match Ups
				ArrayList<MatchUp> previouslySelectedMatches = new ArrayList<MatchUp>();
				previouslySelectedMatches.addAll(seasonMatchUps);
				
			// League
				FantasyLeague matchTestLeague = new FantasyLeague();
				matchTestLeague.setLeague();
					
			// Available Teams To Select From For Match
				ArrayList<FantasyTeam> availableTeamsForMatch = new ArrayList<FantasyTeam>();
				availableTeamsForMatch.addAll(matchTestLeague.getTeams());
							
			// Number of Teams to Select From For Match
				int numberOfTeamsForMatch = matchTestLeague.getNumberOfTeams();
							
		// Testing Game Implementation	
				
			// Selection of Teams for Match
				match.setMatchUp(availableTeamsForMatch, numberOfTeamsForMatch, previouslySelectedMatches);
				
				System.out.println(" Match Number " + i + " : " + match);
				
				if(match.teamOne.getTeamName().equalsIgnoreCase(match.teamTwo.getTeamName())) {
					System.out.print(" INVALID MATCH !!!!");
					break;
				}
				
				else {
					System.out.print("	VALID MATCH !!!!\n\n");
					seasonMatchUps.add(match);
				}
				
				
		}
	}  

	// Testing Season Length Method
	// tests the season length given number of teams
		public int testingSeasonLengthFunction() {
		
			// Testing Fields
			
				// Season Length
				int thisSeasonLength = 1;
			
				// Teams Per Match
				int teamsPerMatch =2;
				
					for(int i = 0;i<15;i++) {
						if(i<2)
							System.out.println("This League Does Not Have Enough Teams");
						
						if(i>=2 && i<13) {
							SeasonLength testLength = new SeasonLength();
							thisSeasonLength = testLength.numberOfPossibleWeeks(i, teamsPerMatch);
							System.out.println("Number of Teams : " + i);
							System.out.println("Season Length : " + thisSeasonLength + " Weeks ");	
						}
						
						if(i>=13)
							System.out.println("This League Does Not Have Enough Teams");
					}
					
			return thisSeasonLength;
		
		}
			
	// Testing Game Run Method
	// tests the method which runs the games
		public Game testingSetGameFunction() {
			
			// Method Fields
			
				// Game Return
					Game testSetGame = new Game();
			
			
				// Previously Selected Match Ups
					ArrayList<MatchUp> previouslySelectedMatches = new ArrayList<MatchUp>();
					previouslySelectedMatches.addAll(seasonMatchUps);
			
				// League
					FantasyLeague gameTestLeague = new FantasyLeague();
					gameTestLeague.setLeague();
						
					
				// Available Teams To Select From For Game
					ArrayList<FantasyTeam> availableTeamsForGame =  new ArrayList<FantasyTeam>();
					availableTeamsForGame.addAll(gameTestLeague.getTeams());
								
				// Number of Teams to Select From For Game
					int numberOfTeamsForGame = gameTestLeague.getNumberOfTeams();
								
					
			// Method Implementation
				
				testSetGame.setGame(availableTeamsForGame, numberOfTeamsForGame, previouslySelectedMatches);	
				
				System.out.println(testSetGame.getGameMatchUp());
				System.out.println(testSetGame.getGameVictor());
				System.out.println(testSetGame.getGameLoser());
				
//				if(testSetGame.getGameVictor().getTeamName().equalsIgnoreCase("Revature Ravagers"))
//					System.out.println(" Game Victor : " + testSetGame.getGameVictor().getTeamName() + "			| Wins : " + testSetGame.getGameVictor().getTeamWins() + " Losses : " + testSetGame.getGameVictor().getTeamLoss());
//				else
//					System.out.println(" Game Victor : " + testSetGame.getGameVictor().getTeamName() + "				| Wins : " + testSetGame.getGameVictor().getTeamWins() + " Losses : " + testSetGame.getGameVictor().getTeamLoss());
//				
//				if(testSetGame.getGameLoser().getTeamName().equalsIgnoreCase("Revature Ravagers"))
//					System.out.println(" Game Loser  : " + testSetGame.getGameLoser().getTeamName() +  "			| Wins : " + testSetGame.getGameLoser().getTeamWins() + " Losses : " + testSetGame.getGameLoser().getTeamLoss());
//				else
//					System.out.println(" Game Loser  : " + testSetGame.getGameLoser().getTeamName() +  "				| Wins : " + testSetGame.getGameLoser().getTeamWins() + " Losses : " + testSetGame.getGameLoser().getTeamLoss());
	
				System.out.println();
			return testSetGame;
		}
	
	// Testing Simulate Week Method
	// tests the method which simulates a single week
	public FantasyLeague testingSimWeekFunction() {
		
		// Method Fields
			
			// Input League
				FantasyLeague beginningWeekLeague = new FantasyLeague();
				beginningWeekLeague.setLeague();
			
			// Output League
				FantasyLeague endingWeekLeague = new FantasyLeague();
				endingWeekLeague.setLeague();
				
			// Current Week 		
				System.out.println("------------------------------- \n");
				System.out.println("Week Number : " + weekNumber);
				Week thisWeek = new Week();
			
			// Team Results
				ArrayList<TeamResults> teamFPS = new ArrayList<TeamResults>();
					setTestTeamFPS(teamFPS);
			
		// Method Implementation
					
					// Updates League Given Previous Week
					System.out.println(beginningWeekLeague.displayTeamsByWins());
					endingWeekLeague = thisWeek.simWeek(beginningWeekLeague, seasonMatchUps, teamFPS);
					System.out.println(endingWeekLeague.displayTeamsByWins());
	
		seasonMatchUps.addAll(thisWeek.selectedWeeklyMatchUps);
		
		weekNumber++;
		endingWeekLeague.setNumberOfTeams(endingWeekLeague.getTeams().size());

		endingWeekLeague.endSimulation(endingWeekLeague);
		
		return endingWeekLeague;
	}

	private void setTestTeamFPS(ArrayList<TeamResults> teamFPS) {
		TeamResults Andres = new TeamResults();
			Andres.setTeamName("Andres Tiburones");
			Andres.setTeampFPS(new BigDecimal(18));
			
		teamFPS.add(Andres);
			
		TeamResults Majal = new TeamResults();
			Majal.setTeamName("Majal Towers");
			Majal.setTeampFPS(new BigDecimal(12));
		
		teamFPS.add(Majal);
		
		TeamResults Revature = new TeamResults();
			Revature.setTeamName("Revature Ravagers");
			Revature.setTeampFPS(new BigDecimal(16));
			
		teamFPS.add(Revature);
		
		TeamResults Gordon = new TeamResults();
			Gordon.setTeamName("Gordon Flashes");
			Gordon.setTeampFPS(new BigDecimal(2));
			
		teamFPS.add(Gordon);
		
		TeamResults Khalifa = new TeamResults();
			Khalifa.setTeamName("Khalifa Cheebas");
			Khalifa.setTeampFPS(new BigDecimal(4));
			
		teamFPS.add(Khalifa);
		
		TeamResults Dillon = new TeamResults();
			Dillon.setTeamName("Dillon Dillos");
			Dillon.setTeampFPS(new BigDecimal(6));

		teamFPS.add(Dillon);
	}
}
