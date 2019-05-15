package com.revature.fantasyfootball;

import java.util.Random;

public class schedule {
	
	public void weekOne() {
		
		matchUp games = new matchUp();
		games.weekOne();
		
	
	}
	
	public   void weekTwo() {
			
			matchUp gameOne = new matchUp();
			
			gameOne.teamOne = "Tiburones";
			gameOne.teamTwo = "Flashes";
			
			System.out.println(gameOne.teamOne +" vs. "+ gameOne.teamTwo);
			
			matchUp gameTwo = new matchUp();
			
			gameTwo.teamOne = "Cheebas";
			gameTwo.teamTwo = "Towers";
			
			System.out.println(gameTwo.teamOne +" vs. "+ gameTwo.teamTwo);
			
			matchUp gameThree = new matchUp();
			
			gameThree.teamOne = "Dillos";
			gameThree.teamTwo = "Ravagers";	
			
			System.out.println(gameThree.teamOne +" vs. "+ gameThree.teamTwo);
		}
	
	public void weekThree() {
		
		matchUp gameOne = new matchUp();
		
		gameOne.teamOne = "Towers";
		gameOne.teamTwo = "Tiburones";
		
		System.out.println(gameOne.teamOne +" vs. "+ gameOne.teamTwo);
		
		matchUp gameTwo = new matchUp();
		
		gameTwo.teamOne = "Cheebas";
		gameTwo.teamTwo = "Dillos";
		
		System.out.println(gameTwo.teamOne +" vs. "+ gameTwo.teamTwo);
		
		matchUp gameThree = new matchUp();
		
		gameThree.teamOne = "Flashes";
		gameThree.teamTwo = "Ravagers";	
		
		System.out.println(gameThree.teamOne +" vs. "+ gameThree.teamTwo);
	}
	
	public void weekFour() {
			
			matchUp gameOne = new matchUp();
			
			gameOne.teamOne = "Tiburones";
			gameOne.teamTwo = "Dillos";
			
			System.out.println(gameOne.teamOne +" vs. "+ gameOne.teamTwo);
			
			matchUp gameTwo = new matchUp();
			
			gameTwo.teamOne = "Cheebas";
			gameTwo.teamTwo = "Ravagers";
			
			System.out.println(gameTwo.teamOne +" vs. "+ gameTwo.teamTwo);
			
			matchUp gameThree = new matchUp();
			
			gameThree.teamOne = "Flashes";
			gameThree.teamTwo = "Towers";	
			
			System.out.println(gameThree.teamOne +" vs. "+ gameThree.teamTwo);
	}
	
	public void weekFive() {
		
		matchUp gameOne = new matchUp();
		
		gameOne.teamOne = "Tiburones";
		gameOne.teamTwo = "Ravagers";
		
		System.out.println(gameOne.teamOne +" vs. "+ gameOne.teamTwo);
		
		matchUp gameTwo = new matchUp();
		
		gameTwo.teamOne = "Cheebas";
		gameTwo.teamTwo = "Flashes";
		
		System.out.println(gameTwo.teamOne +" vs. "+ gameTwo.teamTwo);
		
		matchUp gameThree = new matchUp();
		
		gameThree.teamOne = "Dillos";
		gameThree.teamTwo = "Towers";	
		
		System.out.println(gameThree.teamOne +" vs. "+ gameThree.teamTwo);
	}
	
	
	
	
	private String headToHead(matchUp gameOne) {
		Random teamFPS = new Random();
		
		gameOne.teamOneFPS = teamFPS.nextInt(100);
		gameOne.teamTwoFPS = teamFPS.nextInt(100);
		
		if(gameOne.teamOneFPS>gameOne.teamTwoFPS) 
			gameOne.victor = gameOne.teamOne;
		
		if(gameOne.teamOneFPS<gameOne.teamTwoFPS)
			gameOne.victor = gameOne.teamTwo;
		
		if(gameOne.teamOneFPS==gameOne.teamTwoFPS)
			gameOne.victor = "Draw";
		
		String gameOneVictor = gameOne.victor;
		
		return gameOneVictor;
	}
}
