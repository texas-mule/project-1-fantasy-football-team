package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
			public FantasyLeague simWeekFunction(@WebParam(name = "team") ArrayList<TeamResults> teamResults) {
				System.out.println(" INPUT ");
				for(TeamResults r:teamResults)
				{
					System.out.println(r.teamName);
					System.out.println(r.teamFPS);
					
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
			
/*******************************************************************************************************************************************/
/************************************************* SERVICE TEST FUNCTIONS ******************************************************************/
/*******************************************************************************************************************************************/

	// Team Service Test Functions
		
		/**********************************/
		// TESTING SEASON LENGTH FUNCTION //			FUNCTIONAL √
		/**********************************/	
		// tests the season length given number of teams
			@WebMethod
			public int testingSeasonLengthFunction() {
				
				// Testing Fields
					
					// Season Length
						int thisSeasonLength = 1;
					
					// Teams Per Match
						int teamsPerMatch =2;
						
						for(int i = 0;i<15;i++) {
							
							// If Less Than Two Teams
							// not enough teams
								if(i<2)
									System.out.println("This League Does Not Have Enough Teams");
							
							// If Between Two And Twelve
							// enough teams
								if(i>=2 && i<13) {
									SeasonLength testLength = new SeasonLength();
									thisSeasonLength = testLength.numberOfPossibleWeeks(i, teamsPerMatch);
									System.out.println("Number of Teams : " + i);
									System.out.println("Season Length : " + thisSeasonLength + " Weeks ");	
								}
							
							// If More Than Twelve
							// too many teams
								if(i>=13)
									System.out.println("This League Does Not Have Enough Teams");
						}
				
				// Return Total Amount Of Weeks
				return thisSeasonLength;
			}
			
				
	// Testing Game Selection Method
	// tests the method which sets up games
		/************************************/
		// TESTING MATCH SELECTION FUNCTION //			FUNCTIONAL √
		/************************************/
		// tests the match selection for a single game
			@WebMethod
			public ArrayList<MatchUp> testingMatchSelectionFunction() {
								
			// Testing Game Fields	
				
				// Possible Matches
					SeasonLength thisSeasonLength = new SeasonLength();
					int totalMatches = thisSeasonLength.numberOfPossibleMatches(6, 2);
									
				for(int i =0;i < totalMatches ;i++) {
				
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
					
					System.out.println(" Match Number " + (i+1) + " : " + match);
					
					if(match.teamOne.getTeamName().equalsIgnoreCase(match.teamTwo.getTeamName())) {
						break;
					}
					
					else {
						seasonMatchUps.add(match);
					}
					
					
					}
					return seasonMatchUps;
				}  

		/******************************/
		// TESTING RUN GAME FUNCTION //					
		/*****************************/
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
				
				if(testSetGame.getGameVictor().getTeamName().equalsIgnoreCase("Revature Ravagers"))
					System.out.println("Game Victor : " + testSetGame.getGameVictor().getTeamName() + "			| Wins : " + testSetGame.getGameVictor().getTeamWins() + " Losses : " + testSetGame.getGameVictor().getTeamLoss());
				else
					System.out.println("Game Victor : " + testSetGame.getGameVictor().getTeamName() + "				| Wins : " + testSetGame.getGameVictor().getTeamWins() + " Losses : " + testSetGame.getGameVictor().getTeamLoss());
				
				if(testSetGame.getGameLoser().getTeamName().equalsIgnoreCase("Revature Ravagers"))
					System.out.println("Game Loser  : " + testSetGame.getGameLoser().getTeamName() +  "			| Wins : " + testSetGame.getGameLoser().getTeamWins() + " Losses : " + testSetGame.getGameLoser().getTeamLoss());
				else
					System.out.println("Game Loser  : " + testSetGame.getGameLoser().getTeamName() +  "				| Wins : " + testSetGame.getGameLoser().getTeamWins() + " Losses : " + testSetGame.getGameLoser().getTeamLoss());
	
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
			Andres.setTeamFPS(new BigDecimal(18));
			
		teamFPS.add(Andres);
			
		TeamResults Majal = new TeamResults();
			Majal.setTeamName("Majal Towers");
			Majal.setTeamFPS(new BigDecimal(12));
		
		teamFPS.add(Majal);
		
		TeamResults Revature = new TeamResults();
			Revature.setTeamName("Revature Ravagers");
			Revature.setTeamFPS(new BigDecimal(16));
			
		teamFPS.add(Revature);
		
		TeamResults Gordon = new TeamResults();
			Gordon.setTeamName("Gordon Flashes");
			Gordon.setTeamFPS(new BigDecimal(2));
			
		teamFPS.add(Gordon);
		
		TeamResults Khalifa = new TeamResults();
			Khalifa.setTeamName("Khalifa Cheebas");
			Khalifa.setTeamFPS(new BigDecimal(4));
			
		teamFPS.add(Khalifa);
		
		TeamResults Dillon = new TeamResults();
			Dillon.setTeamName("Dillon Dillos");
			Dillon.setTeamFPS(new BigDecimal(6));

		teamFPS.add(Dillon);
	}
}
