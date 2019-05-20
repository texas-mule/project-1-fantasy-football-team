package com.revature.fantasyfootball;

public class SeasonLength {

	public int seasonLength;
	
	public int numberOfPossibleWeeks(int numberOfTeams, int teamsPerMatch) {
		
		int numerator = factorial(numberOfTeams);
		
		int firstDenominator = factorial(teamsPerMatch);
		
		int secondDenominator = factorial(numberOfTeams-teamsPerMatch);
		
		int total = numerator / (firstDenominator*secondDenominator);
		
		return total /(numberOfTeams/2);
	}
	
public int numberOfPossibleMatches(int numberOfTeams, int teamsPerMatch) {
		
		int numerator = factorial(numberOfTeams);
		
		int firstDenominator = factorial(teamsPerMatch);
		
		int secondDenominator = factorial(numberOfTeams-teamsPerMatch);
		
		int total = numerator / (firstDenominator*secondDenominator);
		
		return total;
	}

	public int factorial(int n){
		  if (n == 0)    
			    return 1;    
		  else    
			    return(n * factorial(n-1));    
	}
}
