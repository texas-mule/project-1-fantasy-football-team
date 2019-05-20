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
			public FantasyLeague simWeekFunction(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {

				// Method Fields
				
					// Input Results
						System.out.println(" INPUT \n");
						for(TeamResult r:teamResults)
						{
							if(r.teamName.equalsIgnoreCase("Majal Towers"))
								System.out.println(r.teamName + " : " + "	 	 FPS: " + r.teamFPS);
							else
								System.out.println(r.teamName + " : " + "	 FPS: " + r.teamFPS);
							
							System.out.println("------------------------------------------------");
							
						}
					
					// Input League
						System.out.println("\n-----------------------------------------------------------------");
						System.out.println("SETTING LEAGUE FPS\n");
						FantasyLeague beginningWeekLeague = new FantasyLeague();
						beginningWeekLeague.setLeague();
						for(TeamResult r:teamResults)
						{
							for(FantasyTeam team: beginningWeekLeague.getTeams()) {
								if(team.getTeamName().equalsIgnoreCase(r.getTeamName())) {
									team.setTeamFPS(r.getTeamFPS());
									if(r.teamName.equalsIgnoreCase("Majal Towers"))
										System.out.println(r.teamName + " : " + "	 	 FPS: " + r.teamFPS);
									else
										System.out.println(r.teamName + " : " + "	 FPS: " + r.teamFPS);
									
									System.out.println("------------------------------------------------");
								}
							}
						}
						
					// Output League
						FantasyLeague endingWeekLeague = new FantasyLeague();
						endingWeekLeague.setLeague();
						
					// Current Week 		
						System.out.println("Week Number : " + weekNumber);
						Week thisWeek = new Week();
					
					// Team Results
						ArrayList<TeamResult> teamFPS = new ArrayList<TeamResult>();
						teamFPS.addAll(teamResults);
					
				// Method Implementation
							// Updates League Given Previous Week
							endingWeekLeague = thisWeek.simWeek(beginningWeekLeague, seasonMatchUps);
							endingWeekLeague.displayTeamsByWinsStats();
			
				seasonMatchUps.addAll(thisWeek.selectedWeeklyMatchUps);
				
				weekNumber++;
				endingWeekLeague.setNumberOfTeams(endingWeekLeague.getTeams().size());

				endingWeekLeague.updateLeagueRanks();
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
		// TESTING RUN GAME FUNCTION //					FUNCTIONAL √					
		/*****************************/
		// tests the method which runs the games
			public Game testingSetGameFunction(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
				
				// Method Fields
				
					// Game Return
						Game testSetGame = new Game();
						
					// Previously Selected Match Ups
						ArrayList<MatchUp> previouslySelectedMatches = new ArrayList<MatchUp>();
						previouslySelectedMatches.addAll(seasonMatchUps);
				
					// League
						FantasyLeague gameTestLeague = new FantasyLeague();
						gameTestLeague.setLeague();
						
					// Set League Team FPS
						
						// For Each Team Result
							for(TeamResult result:teamResults)
							{
								// For Each Team
									for(FantasyTeam team: gameTestLeague.getTeams()) {
										
										// If Team Result Name == Team Name Assign FPS
											if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
												team.setTeamFPS(result.getTeamFPS());
												System.out.println(team.getTeamName() + " " +team.getTeamFPS());
											}
									}
							}
									
					// Number of Teams to Select From For Game
						int numberOfTeamsForGame = gameTestLeague.getTeams().size();
									
						
				// Method Implementation
					
					// Play The Game
					testSetGame.setGame(gameTestLeague.getTeams(), numberOfTeamsForGame, previouslySelectedMatches);	
					
					// Print Match Up
					testSetGame.getGameMatchUp().printMatchUp();
					
					System.out.println("---------------------------");
					
					if(testSetGame.getGameVictor().getTeamName().equalsIgnoreCase("Revature Ravagers"))
						System.out.println("Game Victor : " + testSetGame.getGameVictor().getTeamName() + "			| Wins : " + testSetGame.getGameVictor().getTeamWins() + " Losses : " + testSetGame.getGameVictor().getTeamLoss());
					else
						System.out.println("Game Victor : " + testSetGame.getGameVictor().getTeamName() + "			| Wins : " + testSetGame.getGameVictor().getTeamWins() + " Losses : " + testSetGame.getGameVictor().getTeamLoss());
					
					if(testSetGame.getGameLoser().getTeamName().equalsIgnoreCase("Revature Ravagers"))
						System.out.println("Game Loser  : " + testSetGame.getGameLoser().getTeamName() +  "			| Wins : " + testSetGame.getGameLoser().getTeamWins() + " Losses : " + testSetGame.getGameLoser().getTeamLoss());
					else
						System.out.println("Game Loser  : " + testSetGame.getGameLoser().getTeamName() +  "			| Wins : " + testSetGame.getGameLoser().getTeamWins() + " Losses : " + testSetGame.getGameLoser().getTeamLoss());
		
					System.out.println();
							
				gameTestLeague.displayTeamsByWins();
				
				return testSetGame;
			}
	
		/********************************/
		// Testing Simulate Week Method // 
		/********************************/
		// tests the method which simulates a single week
			@WebMethod
			public FantasyLeague testingSimWeekFunction(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
				
				// Method Fields
				
					// Input Results
						System.out.println(" INPUT \n");
						for(TeamResult r:teamResults)
						{
							if(r.teamName.equalsIgnoreCase("Majal Towers"))
								System.out.println(r.teamName + " : " + "	 	 FPS: " + r.teamFPS);
							else
								System.out.println(r.teamName + " : " + "	 FPS: " + r.teamFPS);
							
							System.out.println("------------------------------------------------");
							
						}
					
					// Input League
						System.out.println("\n-----------------------------------------------------------------");
						System.out.println("SETTING LEAGUE FPS\n");
						FantasyLeague beginningWeekLeague = new FantasyLeague();
						beginningWeekLeague.setLeague();
						for(TeamResult r:teamResults)
						{
							for(FantasyTeam team: beginningWeekLeague.getTeams()) {
								if(team.getTeamName().equalsIgnoreCase(r.getTeamName())) {
									team.setTeamFPS(r.getTeamFPS());
									if(r.teamName.equalsIgnoreCase("Majal Towers"))
										System.out.println(r.teamName + " : " + "	 	 FPS: " + r.teamFPS);
									else
										System.out.println(r.teamName + " : " + "	 FPS: " + r.teamFPS);
									
									System.out.println("------------------------------------------------");
								}
							}
						}
						
					// Output League
						FantasyLeague endingWeekLeague = new FantasyLeague();
						endingWeekLeague.setLeague();
						
					// Current Week 		
						System.out.println("Week Number : " + weekNumber);
						Week thisWeek = new Week();
					
					// Team Results
						ArrayList<TeamResult> teamFPS = new ArrayList<TeamResult>();
						teamFPS.addAll(teamResults);
					
				// Method Implementation
							// Updates League Given Previous Week
							endingWeekLeague = thisWeek.simWeek(beginningWeekLeague, seasonMatchUps);
							endingWeekLeague.displayTeamsByWinsStats();
			
				seasonMatchUps.addAll(thisWeek.selectedWeeklyMatchUps);
				
				weekNumber++;
				endingWeekLeague.setNumberOfTeams(endingWeekLeague.getTeams().size());

				endingWeekLeague.updateLeagueRanks();
				endingWeekLeague.endSimulation(endingWeekLeague);
				
				return endingWeekLeague;
			}

	private void setTestTeamFPS(ArrayList<TeamResult> teamFPS) {
		TeamResult Andres = new TeamResult();
			Andres.setTeamName("Andres Tiburones");
			Andres.setTeamFPS(new BigDecimal(18));
			
		teamFPS.add(Andres);
			
		TeamResult Majal = new TeamResult();
			Majal.setTeamName("Majal Towers");
			Majal.setTeamFPS(new BigDecimal(12));
		
		teamFPS.add(Majal);
		
		TeamResult Revature = new TeamResult();
			Revature.setTeamName("Revature Ravagers");
			Revature.setTeamFPS(new BigDecimal(16));
			
		teamFPS.add(Revature);
		
		TeamResult Gordon = new TeamResult();
			Gordon.setTeamName("Gordon Flashes");
			Gordon.setTeamFPS(new BigDecimal(2));
			
		teamFPS.add(Gordon);
		
		TeamResult Khalifa = new TeamResult();
			Khalifa.setTeamName("Khalifa Cheebas");
			Khalifa.setTeamFPS(new BigDecimal(4));
			
		teamFPS.add(Khalifa);
		
		TeamResult Dillon = new TeamResult();
			Dillon.setTeamName("Dillon Dillos");
			Dillon.setTeamFPS(new BigDecimal(6));

		teamFPS.add(Dillon);
	}
}
