package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
 public class TeamService {
	
/*******************************************************************************************************************************************/
/********************************************************* SERVICE FIELDS *********************************************************************/
/*******************************************************************************************************************************************/

	// Team Service Fields
	
		// Week Count
			int weekNumber = 1;

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

				// Testing Game Fields	
				
				// League
					FantasyLeague weekLeague = new FantasyLeague();
					weekLeague.setLeague();
					
					try {
								TestWeekSimulationClass test = new TestWeekSimulationClass();
								test.simWeekFunction(teamResults, weekLeague, seasonMatchUps, weekNumber);
								weekNumber++;

					weekLeague.updateLeagueRanks();
					weekLeague.endSimulation(weekLeague);
					} catch (Exception e) {
						System.out.println("\nSEASON COMPLETE");
					}
					
					return weekLeague;
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
			@WebResult(name="Match")
			public ArrayList<MatchUp> testingMatchSelectionFunction() {
				
			
			// Testing Game Fields	
				
				// Possible Matches
					SeasonLength thisSeasonLength = new SeasonLength();
					int totalMatches = thisSeasonLength.numberOfPossibleMatches(6, 2);
					
				// League
					FantasyLeague matchTestLeague = new FantasyLeague();
					matchTestLeague.setLeague();
					
				if(seasonMatchUps.size()<totalMatches) {
					
					for(int i =0;i < totalMatches ;i++) {
					
						int gameNumber = i;
						
						// Match Up Return
							MatchUp match = new MatchUp();
						
						// Previously Selected Match Ups
							ArrayList<MatchUp> previouslySelectedMatches = new ArrayList<MatchUp>();
							previouslySelectedMatches.addAll(seasonMatchUps);
			
										
						// Number of Teams to Select From For Match
							int numberOfTeamsForMatch = matchTestLeague.getNumberOfTeams();
										
					// Testing Game Implementation	
							
						// Selection of Teams for Match
							match.setMatchUp(matchTestLeague.getTeams(), weekNumber, gameNumber);
							System.out.println(" Match Number " + (i+1) + " : " + match);
							
						// Add Match Up To Season Match Ups
							seasonMatchUps.add(match);	
					}
				
				// Print Results
					
					for(FantasyTeam leagueTeams: matchTestLeague.getTeams()) {
						System.out.println();
						System.out.println(leagueTeams.getTeamName() + "\n ---------------- \n");
						for(MatchUp seasonMatch: seasonMatchUps) {
							if(seasonMatch.teamOne.getTeamName().equalsIgnoreCase(leagueTeams.getTeamName()))
									System.out.println(" Played Against : " + seasonMatch.getTeamTwo().printTeamName());
							
							if(seasonMatch.teamTwo.getTeamName().equalsIgnoreCase(leagueTeams.getTeamName()))
								System.out.println(" Played Against : " + seasonMatch.getTeamOne().printTeamName());
						}
					}
					
				}
				// If No Further Matches
					else
						System.out.println("\nNo Further Matches Can Be Made");
				
				return seasonMatchUps;
			}  

		/******************************/
		// TESTING RUN GAME FUNCTION //					FUNCTIONAL √					
		/*****************************/
/***
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
					testSetGame.setGame(gameTestLeague, numberOfTeamsForGame, previouslySelectedMatches);	
					
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
*****/
			
		/********************************/
		// Testing Simulate Week Method // 
		/********************************/	
/**
		// tests the method which simulates a single week
			@WebMethod
			public FantasyLeague testingSimWeekFunction(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
				
				// Method Fields
				
					// Input Results
						System.out.println(" INPUT \n");
					
					// Input League
						System.out.println("\n-----------------------------------------------------------------");
						System.out.println("SETTING LEAGUE FPS\n");
						FantasyLeague beginningWeekLeague = new FantasyLeague();
						beginningWeekLeague.setLeague();
						
					// Ensuring Week Range
						SeasonLength thisSeasonLength = new SeasonLength();
						if(weekNumber<thisSeasonLength.numberOfPossibleWeeks(beginningWeekLeague.getTeams().size(), 2)) {
						
							// Assign League FPS
								for(TeamResult result:teamResults){
									for(FantasyTeam team: beginningWeekLeague.getTeams()) {
										if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
											team.setTeamFPS(result.getTeamFPS());
										}
									}
								}
							
							// Output League
								FantasyLeague endingWeekLeague = new FantasyLeague();
								endingWeekLeague.setLeague();
								
							// Current Week 		
								System.out.println("\nWeek Number : " + weekNumber);
								Week thisWeek = new Week();
						
						// Method Implementation
								
							// Updates League Given Previous Week
								endingWeekLeague = thisWeek.simWeek(beginningWeekLeague, seasonMatchUps);
								endingWeekLeague.displayTeamsByWinsStats();
					
								
					weekNumber++;
					
					endingWeekLeague.setNumberOfTeams(endingWeekLeague.getTeams().size());
	
					endingWeekLeague.updateLeagueRanks();
					endingWeekLeague.endSimulation(endingWeekLeague);
					return endingWeekLeague;
					
					}
						else
							System.out.println("\nSEASON COMPLETED");
						
						
				return beginningWeekLeague;
			}
**/
		
			/************************************/
			// TESTING MATCH SELECTION DEMO FUNCTION //			FUNCTIONAL √
			/************************************/
			// tests the match selection for a single game
				@WebMethod
				@WebResult(name="Match")
				public ArrayList<MatchUp> testingMatchSelectionFunctionDEMO() {
					
				// Testing Game Fields	
					
					// Possible Matches
						SeasonLength thisSeasonLength = new SeasonLength();
						int totalMatches = thisSeasonLength.numberOfPossibleMatches(6, 2);
						
					// League
						FantasyLeague matchTestLeague = new FantasyLeague();
						matchTestLeague.setLeague();
						
						int m=0;
						
						for(int w =1;w <= 5 ;w++) {
							
							weekNumber = w;
							for(int g =1;g <= 3 ;g++) {
								int gameNumber = g;
								m++;
								TestMatchSelectionClass test = new TestMatchSelectionClass();
								test.testingMatchSelectionFunction(matchTestLeague, weekNumber, gameNumber);
								System.out.println("\n Match Number " + m + "  : " + test.match.teamOne.getTeamName() + " vs. " + test.match.teamTwo.getTeamName());
								
							}
						}
						

					return seasonMatchUps;
				}

				/************************************/
				// TESTING RUN GAME DEMO FUNCTION //			FUNCTIONAL √
				/************************************/
				// tests the match selection for a single game
					@WebMethod
					@WebResult(name="Match")
					public FantasyLeague testingRunGameFunctionDEMO(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
						
					// Testing Game Fields	
						// Possible Matches
						SeasonLength thisSeasonLength = new SeasonLength();
						int totalMatches = thisSeasonLength.numberOfPossibleMatches(6, 2);
						
					// League
						FantasyLeague gameTestLeague = new FantasyLeague();
						gameTestLeague.setLeague();
						try {
							
							
							// Assign FPS
								for(TeamResult result:teamResults){
									for(FantasyTeam team: gameTestLeague.getTeams()) {
										if(team.getTeamName().equalsIgnoreCase(result.getTeamName())) {
											team.setTeamFPS(result.getTeamFPS());
										}
									}
								}
								
								for(int i =0;i < totalMatches ;i++) {
									
									int gameNumber = i;
							
									TestRunGameClass test = new TestRunGameClass();
									test.testingRunGameFunction(gameTestLeague, weekNumber, gameNumber);
								}
						} catch (Exception e) {
							System.out.println("\nNO FURTHER GAMES CAN BE PLAYED");
						}

						gameTestLeague.updateLeagueRanks();
						return gameTestLeague;
					}
					
					/************************************/
					// TESTING WEEK SIMULATION DEMO FUNCTION //			FUNCTIONAL √
					/************************************/
					// tests the match selection for a single game
						@WebMethod
						@WebResult(name="Match")
						public FantasyLeague testingWeekSimulationDEMO(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
							
						// Testing Game Fields	
							
						// League
							FantasyLeague weekTestLeague = new FantasyLeague();
							weekTestLeague.setLeague();
							try {
										TestWeekSimulationClass test = new TestWeekSimulationClass();
										test.simWeekFunction(teamResults, weekTestLeague, seasonMatchUps, weekNumber);
										weekNumber++;
							} catch (Exception e) {
								System.out.println("\nSEASON COMPLETE");
							}

							weekTestLeague.updateLeagueRanks();
							return weekTestLeague;
						}
						
						/************************************/
						// TESTING SEASON SIMULATION DEMO FUNCTION //			FUNCTIONAL √
						/************************************/
						// tests the match selection for a single game
							@WebMethod
							@WebResult(name="Match")
							public FantasyLeague testingSeasonSimulationDEMO(@WebParam(name = "team") ArrayList<TeamResult> teamResults) {
								
							// Testing Game Fields	
								// Possible Matches
								SeasonLength thisSeasonLength = new SeasonLength();
								int totalWeeks = thisSeasonLength.numberOfPossibleWeeks(6, 2);
							// League
								FantasyLeague seasonTestLeague = new FantasyLeague();
								seasonTestLeague.setLeague();
								try {
									
									for(int i =0;i < totalWeeks ;i++) {
											TestWeekSimulationClass test = new TestWeekSimulationClass();
											test.simWeekFunction(teamResults, seasonTestLeague, seasonMatchUps, weekNumber);
											weekNumber++;
									}
								} catch (Exception e) {
									System.out.println("\nSEASON COMPLETE");
								}
								seasonTestLeague.updateLeagueRanks();
								return seasonTestLeague;
							}









}
