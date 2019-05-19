package com.revature.fantasyfootball;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
 public class TeamService {
	
/*******************************************************************************************************************************************/
/********************************************************* SERVICE FIELDS *********************************************************************/
/*******************************************************************************************************************************************/

	// Team Service Fields
	
		// Week Count
			int weekNumber = 0;
	
		// Season Match Ups Hash Map
			HashMap<FantasyTeam, List<FantasyTeam>> selectedSeasonMatchUps = new HashMap<FantasyTeam, List<FantasyTeam>>();
			
		// Season Match Ups Array List
			ArrayList<MatchUp> seasonMatchUps = new ArrayList<>();


/*******************************************************************************************************************************************/
/*********************************************** SERVICE GETTERS ANDS SETTERS *****************************************************************/
/*******************************************************************************************************************************************/	

	// Team Service Getters and Setters
			
/*******************************************************************************************************************************************/
/************************************************* SERVICE FUNCTIONS **************************************************************************/
/*******************************************************************************************************************************************/

				
/*******************************************************************************************************************************************/
/************************************************* SERVICE TEST FUNCTIONS ******************************************************************/
/*******************************************************************************************************************************************/

// Team Service Test Functions
				
	// Testing Game Selection Method
	// tests the method which sets up games
	@WebMethod
	public MatchUp testingGameSelectionFunction() {
							
		// Testing Game Fields
					
			// Match Up Return
					MatchUp returningObject = new MatchUp();
								
		for(int i =0;i<=100;i++) {
			
			// League
				FantasyLeague testingGameLeague = new FantasyLeague();
				testingGameLeague.setLeague();
							
			// Game
				Game testTeamSelection = new Game();
							
			// Available Teams To Select From
				ArrayList<FantasyTeam> availableTeamsForRandomGenerator = testingGameLeague.getTeams();
							
			// Number of Teams to Select From
				int numberOfTeamsForRandomGenerator = testingGameLeague.getNumberOfTeams();
							
			// Previously Selected Match Ups
				ArrayList<MatchUp> previouslySelectedMatches = seasonMatchUps;
					
		// Testing Game Implementation	
				
			// Selection of Teams for Game
				returningObject = testTeamSelection.selectTeamsForMatchUp(availableTeamsForRandomGenerator, numberOfTeamsForRandomGenerator, previouslySelectedMatches);
				System.out.println(" Match Number " + i + " : " + returningObject);
				if(returningObject.teamOne.getTeamName().equalsIgnoreCase(returningObject.teamTwo.getTeamName())) {
					System.out.print(" INVALID MATCH !!!!");
					break;
				}
				else
					System.out.print("	VALID MATCH !!!!\n\n");
				}
					
		return  returningObject;
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
	public Game testingRunGameFunction(BigDecimal teamOneFPS, BigDecimal teamTwoFPS) {
		
		// Method Fields
		
			// League
				FantasyLeague testingGameLeague = new FantasyLeague();
				testingGameLeague.setLeague();
					
			// Game
				Game testRunGame = new Game();
				
			// Available Teams To Select From
				ArrayList<FantasyTeam> availableTeamsForRandomGenerator = testingGameLeague.getTeams();
							
			// Number of Teams to Select From
				int numberOfTeamsForRandomGenerator = testingGameLeague.getNumberOfTeams();
							
			// Previously Selected Match Ups
				ArrayList<MatchUp> previouslySelectedMatches = seasonMatchUps;
				
		// Method Implementation
			
			testRunGame.runGame(availableTeamsForRandomGenerator, numberOfTeamsForRandomGenerator, previouslySelectedMatches, teamOneFPS, teamTwoFPS);	
			
			System.out.println(testRunGame.getGameMatchUp().printMatchUp());
			if(testRunGame.getGameVictor().getTeamName().equalsIgnoreCase("Revature Ravagers"))
				System.out.println(" Game Victor : " + testRunGame.getGameVictor().getTeamName() + "			| Wins : " + testRunGame.getGameVictor().getTeamWins() + " Losses : " + testRunGame.getGameVictor().getTeamLoss());
			else
				System.out.println(" Game Victor : " + testRunGame.getGameVictor().getTeamName() + "				| Wins : " + testRunGame.getGameVictor().getTeamWins() + " Losses : " + testRunGame.getGameVictor().getTeamLoss());
			
			if(testRunGame.getGameLoser().getTeamName().equalsIgnoreCase("Revature Ravagers"))
				System.out.println(" Game Loser  : " + testRunGame.getGameLoser().getTeamName() +  "			| Wins : " + testRunGame.getGameLoser().getTeamWins() + " Losses : " + testRunGame.getGameLoser().getTeamLoss());
			else
				System.out.println(" Game Loser  : " + testRunGame.getGameLoser().getTeamName() +  "				| Wins : " + testRunGame.getGameLoser().getTeamWins() + " Losses : " + testRunGame.getGameLoser().getTeamLoss());

			System.out.println();
		return testRunGame;
	}
	
	
	
			// simWeek Method
				// simulates a single week
	@WebMethod
					public FantasyLeague simWeek(BigDecimal team1FPS, BigDecimal team2FPS,BigDecimal team3FPS, BigDecimal team4FPS,BigDecimal team5FPS, BigDecimal team6FPS) {
		
		// Create Array of Season MatchUps
		// maintains a record of teams that have played each other this season;
			ArrayList<MatchUp> seasonMatchUps = new ArrayList<>();
					
		// Create Array for Weekly Winners
		// maintains a record of teams that have won this week
			ArrayList<FantasyTeam> weeklyVictors = new ArrayList<>();
					
		// Create Array of Team FPS
		// holds the input values of fantasy points per team
			ArrayList<BigDecimal> teamFPS = new ArrayList<>();
		// Add input values
			teamFPS.add(team1FPS);
			teamFPS.add(team2FPS);
			teamFPS.add(team3FPS);
			teamFPS.add(team4FPS);
			teamFPS.add(team5FPS);
			teamFPS.add(team6FPS);
			
		// Create New League Object
		// holds information regarding league to be simulated
			FantasyLeague myLeague = new FantasyLeague();
			
		// Set The League
			myLeague.setLeague();
			int numberOfTeams = myLeague.getNumberOfTeams();
			int teamsPerMatch = 2;
			SeasonLength thisSeasonLength = new SeasonLength();
			
		if(weekNumber<= thisSeasonLength.numberOfPossibleWeeks(numberOfTeams, teamsPerMatch)) {
			
			for(int i = 0; i<numberOfTeams;i++) {
				myLeague.getTeams().get(i).setTeamFPS(teamFPS.get(i));
			}
		
			Week weekOne = new Week();
			seasonMatchUps.addAll(weekOne.simWeek(myLeague, numberOfTeams));
			
//			// Print This Week Match Ups
//			System.out.println("This Week Match Ups\n");
//			for(int i =0;i<seasonMatchUps.size();i++)
//				System.out.println(seasonMatchUps.get(i).printMatchUp());
//			System.out.println("-----------------------------");
			
			// Print This Week Winners
			System.out.println("This Week Winners \n");
			weeklyVictors.addAll(weekOne.victors);
			for(int i =0;i<weeklyVictors.size();i++)
				System.out.println("Game "+ (i+1) +"  "+weeklyVictors.get(i).printTeamName());
			
			// Update League Rank
			myLeague.updateLeagueRanks();
			
			
//			// Print Updated League Information
//			System.out.println("\nNew League Information");
//			System.out.println(myLeague);
//			
//			System.out.println("Week : " + weekNumber);
			
			weekNumber++;
			
			System.out.println("\n");
			
			myLeague.endSimulation(myLeague);
			
			return myLeague;
		}
		else {
			System.out.println("Season Has Been Completed");
			myLeague.setLeague();
			System.out.println("The Winner is: " + myLeague.getTeams().get(0));
			return myLeague;
		}
	
	}	
}
