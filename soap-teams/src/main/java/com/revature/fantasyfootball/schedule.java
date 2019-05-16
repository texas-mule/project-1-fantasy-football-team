package com.revature.fantasyfootball;

import java.util.HashMap;

public class schedule {
	
	HashMap<Integer, Integer> chosenWeekMatchUps = new HashMap<>();
	
	public HashMap<Integer, Integer> weekOne() {
		
		matchUp games = new matchUp();
		
		System.out.println("Starting Week One: ");
		chosenWeekMatchUps.putAll(games.weekOne());
		System.out.println(chosenWeekMatchUps);
		System.out.println("Ending Week One: ");
		
		return chosenWeekMatchUps;
	}
	
	public HashMap<Integer, Integer> weekTwo(HashMap<Integer, Integer> chosenSeasonMatchUps) {
		matchUp games = new matchUp();
		
		chosenWeekMatchUps.putAll(chosenSeasonMatchUps);
		
		System.out.println("Starting Week Two: ");
		System.out.println(chosenWeekMatchUps);
		
		games.weekTwo(chosenWeekMatchUps);
		System.out.println(chosenWeekMatchUps);
		System.out.println("Ending Week Two: ");
		
		return chosenWeekMatchUps;
	}
}
