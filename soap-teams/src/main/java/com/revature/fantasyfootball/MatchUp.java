package com.revature.fantasyfootball;

public class MatchUp {

	// MatchUp Fields
		// Team One
		FantasyTeam teamOne = new FantasyTeam();
		// Team Two
		FantasyTeam teamTwo = new FantasyTeam();
	
	// MatchUp Getters and Setters
		public FantasyTeam getTeamOne() {
			return teamOne;
		}
		public void setTeamOne(FantasyTeam teamOne) {
			this.teamOne = teamOne;
		}
		public FantasyTeam getTeamTwo() {
			return teamTwo;
		}
		public void setTeamTwo(FantasyTeam teamTwo) {
			this.teamTwo = teamTwo;
		}
		
	// MatchUp Printer
		@Override
		public String toString() {
			return  teamOne.printTeamName() +" vs. "+ teamTwo.printTeamName() + "\n";
		}
		
		public String printMatchUp() {
			return  teamOne.printTeamName() +" vs. "+ teamTwo.printTeamName() + "\n";
		}
}

