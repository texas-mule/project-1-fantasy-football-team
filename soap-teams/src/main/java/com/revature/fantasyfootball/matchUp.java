package com.revature.fantasyfootball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class matchUp {
	
	String teamOne;
	String teamTwo;	
	int teamOneFPS;
	int teamTwoFPS;
	String victor;
	
	ArrayList<fantasyTeam> fantasyTeams = new ArrayList();
	
	HashMap<Integer, Integer> chosenMatchUps = new HashMap<>();
	
	public void setLeague() {
		DataConnect league = new DataConnect();
		fantasyTeams=league.retrieveTeams();
	}
	
	ArrayList<Integer> chosenTeams = new ArrayList();
	
	public void weekOne() {
		
		setLeague();
		
		int arraySize = fantasyTeams.size();
		
		ArrayList<Integer> availableTeams = new ArrayList();
		
		for(int i = 0;i<=arraySize;i++) {
			availableTeams.add(i);
		}
		
		gameMatch(availableTeams, arraySize, chosenMatchUps);
		
		System.out.println(availableTeams);
		
	}


	private void gameMatch(ArrayList<Integer> availableTeams, int arraySize, HashMap<Integer, Integer> chosenMatchUps) {
		
		int team = getRandomTeam(availableTeams, arraySize);
		
		teamOne = fantasyTeams.get(team).getTeamName();
		availableTeams.remove(team);
		
		team = getRandomTeam(availableTeams, arraySize);
		teamTwo = fantasyTeams.get(team).getTeamName();
		availableTeams.remove(team);
		
		System.out.println(teamOne +" vs. "+ teamTwo);
	}


	private int getRandomTeam(ArrayList<Integer> availableTeams, int arraySize) {
		Random rand = new Random();
		
		int team = rand.nextInt(arraySize);
		
		String repeat;
	
		do {	
			if(availableTeams.contains(team)) {
				repeat = "no";
			}
			else
				repeat = "yes";
		} while(repeat.equalsIgnoreCase("yes"));
		
		return team;
	}
	
	public String getTeamOne() {
		return teamOne;
	}
	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}
	public String getTeamTwo() {
		return teamTwo;
	}
	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}
	public int getTeamOneFPS() {
		return teamOneFPS;
	}
	public void setTeamOneFPS(int teamOneFPS) {
		this.teamOneFPS = teamOneFPS;
	}
	public int getTeamTwoFPS() {
		return teamTwoFPS;
	}
	public void setTeamTwoFPS(int teamTwoFPS) {
		this.teamTwoFPS = teamTwoFPS;
	}
	public String getVictor() {
		return victor;
	}
	public void setVictor(String victor) {
		this.victor = victor;
	}
}
