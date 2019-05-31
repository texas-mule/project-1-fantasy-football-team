package com.revature.fantasyfootball2;

import java.util.ArrayList;

public class TestMatchSelectionClass {
	
	// Match Up Return
	private MatchUp match = new MatchUp();

	public MatchUp getMatch() {
		return match;
	}

	public void setMatch(MatchUp match) {
		this.match = match;
	}

	public void testingMatchSelectionFunction(ArrayList<MatchUp> seasonMatchUps, FantasyLeague matchTestLeague) {
		
		
		// Testing Game Fields	
			
			// Possible Matches
				SeasonLength thisSeasonLength = new SeasonLength();
				int totalMatches = thisSeasonLength.numberOfPossibleMatches(6, 2);
				
			if(seasonMatchUps.size()<totalMatches) {
									
				// Testing Game Implementation	
						
					// Selection of Teams for Match
						match.setMatchUp(matchTestLeague.getTeams(), matchTestLeague.getTeams().size(), seasonMatchUps);
						
					// Add Match Up To Season Match Ups
						seasonMatchUps.add(match);	
				
			}
			// If No Further Matches
				else
					System.out.println("\nNo Further Matches Can Be Made");
		}
}
