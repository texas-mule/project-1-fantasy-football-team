package com.revature.fantasyfootball;

import java.util.ArrayList;

// Create A Week
public class Week {

	// Week Fields
		// Game One
			private Game GameOne = new Game();
		// Game Two
			private Game GameTwo = new Game();
		// Game Three
			private Game GameThree = new Game();
		// Create Array of Available Teams
			ArrayList<FantasyTeam> availableTeams = new ArrayList<>();
		// Create Array of Weekly MatchUps
			ArrayList<MatchUp> weeklyMatchUps = new ArrayList<>();
		// Create Array of Victors
			ArrayList<FantasyTeam> victors = new ArrayList<>();
			
		public ArrayList<MatchUp> simWeek(FantasyLeague myLeague, int numberOfTeams) {
			// Fill Available Teams with Team Indicators
				for(int i =0;i<numberOfTeams;i++) {				
					availableTeams.add(myLeague.getTeams().get(i));	
				}
				
			weeklyMatchUps.add(GameOne.scheduleGame(availableTeams, numberOfTeams));
			availableTeams = GameOne.getAvailableTeams();
			victors.add(GameOne.getGameVictor());
			numberOfTeams--;
			numberOfTeams--;
			
			weeklyMatchUps.add(GameTwo.scheduleGame(availableTeams, numberOfTeams));
			availableTeams = GameTwo.getAvailableTeams();
			victors.add(GameTwo.getGameVictor());
			numberOfTeams--;
			numberOfTeams--;

			weeklyMatchUps.add(GameThree.scheduleGame(availableTeams, numberOfTeams));
			victors.add(GameThree.getGameVictor());
			
			return weeklyMatchUps;
		}

		public ArrayList<FantasyTeam> getVictors() {
			return victors;
		}
}
