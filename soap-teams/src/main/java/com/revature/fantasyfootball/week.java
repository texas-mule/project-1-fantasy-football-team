package com.revature.fantasyfootball;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.revature.fantasyfootball.schedule;
public class week {

	public void simulateWeek() {
		gameResults();
	}
	
	public void gameResults() {
		
		HashMap<Integer, Integer> chosenSeasonMatchUps = new HashMap<>();
		
		schedule twentyeighteen = new schedule();
		chosenSeasonMatchUps.putAll(twentyeighteen.weekOne());
		
		System.out.println("-----------------------------");
		
		chosenSeasonMatchUps.putAll(twentyeighteen.weekTwo(chosenSeasonMatchUps));
		
	}

	public void updateLeagueRank() {
		
		
	}
	
}

