package com.revature.fantasyfootball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class matchUp {
	
	String teamOne;
	String teamTwo;	
	int teamOneFPS;
	int teamTwoFPS;
	String victor;
	
	ArrayList<fantasyTeam> fantasyTeams = new ArrayList<fantasyTeam>();
	ArrayList<Integer> chosenTeams = new ArrayList<Integer>();
	HashMap<Integer, Integer> chosenWeekMatchUps = new HashMap<>();
	
	// Populate League
	public void setLeague() {
		DataConnect league = new DataConnect();
		
		// Set Teams
		fantasyTeams=league.retrieveTeams();
	}
	
	public HashMap<Integer, Integer> weekOne() {
		HashMap<Integer, Integer> chosenWeekMatchUps = new HashMap<>();
		// Call setLeague();
		setLeague();
		
		// Get the number of teams
		int arraySize = fantasyTeams.size();
		
		// Create Array of Available Teams
		ArrayList<Integer> availableTeams = new ArrayList<Integer>();
		for(int i = 0;i<arraySize;i++) {
			availableTeams.add(i);
		}
		
		chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenWeekMatchUps));
		chosenWeekMatchUps.put(chosenTeams.get(0), chosenTeams.get(1));
		chosenWeekMatchUps.put(chosenTeams.get(1), chosenTeams.get(0));
		chosenTeams.clear();
		
		chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenWeekMatchUps));
		chosenWeekMatchUps.put(chosenTeams.get(0), chosenTeams.get(1));
		chosenWeekMatchUps.put(chosenTeams.get(1), chosenTeams.get(0));
		chosenTeams.clear();
		
		chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenWeekMatchUps));
		chosenWeekMatchUps.put(chosenTeams.get(0), chosenTeams.get(1));
		chosenWeekMatchUps.put(chosenTeams.get(1), chosenTeams.get(0));
		chosenTeams.clear();
		
		return chosenWeekMatchUps;
	}
	
	public HashMap<Integer, Integer> weekTwo(HashMap<Integer,Integer>chosenWeekMatchUps) {
		HashMap<Integer, Integer> chosenMatchUps = new HashMap<>();
		
		chosenMatchUps.putAll(chosenWeekMatchUps);
		// Call setLeague();
		setLeague();
		
		// Get the number of teams
		int arraySize = fantasyTeams.size();
		
		// Create Array of Available Teams
		ArrayList<Integer> availableTeams = new ArrayList<Integer>();
		for(int i = 0;i<arraySize;i++) {
			availableTeams.add(i);
		}
		
		String matchExists="Yes";
		while(matchExists.equalsIgnoreCase("Yes")) {
			chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenMatchUps));
			if(chosenTeams.get(1)==chosenMatchUps.get(chosenTeams.get(0)))
				matchExists = "yes";
			else {
				chosenMatchUps.put(chosenTeams.get(0), chosenTeams.get(1));
				break;
			}
		}
		
		
		while(matchExists.equalsIgnoreCase("Yes")) {
			chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenMatchUps));
			if(chosenTeams.get(1)==chosenMatchUps.get(chosenTeams.get(0)))
				matchExists = "yes";
			else {
				chosenMatchUps.put(chosenTeams.get(1), chosenTeams.get(0));
				break;
			}
		}
		
		System.out.println("Here");
		System.out.println(chosenMatchUps);
		chosenTeams.clear();
		
		chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenMatchUps));
		chosenMatchUps.put(chosenTeams.get(0), chosenTeams.get(1));
		chosenMatchUps.put(chosenTeams.get(1), chosenTeams.get(0));
		chosenTeams.clear();
		
		chosenTeams.addAll(gameMatch(availableTeams, arraySize, chosenMatchUps));
		chosenMatchUps.put(chosenTeams.get(0), chosenTeams.get(1));
		chosenMatchUps.put(chosenTeams.get(1), chosenTeams.get(0));
		chosenTeams.clear();
		
		return chosenMatchUps;
	}


	private ArrayList<Integer> gameMatch(ArrayList<Integer> availableTeams, int arraySize, HashMap<Integer, Integer> chosenMatchUps) {
		ArrayList<Integer> availableMatchTeams = new ArrayList<Integer>();
		ArrayList<Integer> chosenMatchTeams = new ArrayList<Integer>();
		availableMatchTeams = availableTeams;
	
		
			// Choose First Team
			int teamNumberOne = getRandomTeam(availableMatchTeams, arraySize);	
			teamOne = fantasyTeams.get(teamNumberOne).getTeamName();
			//System.out.println(teamOne);
			chosenMatchTeams.add(teamNumberOne);
			availableMatchTeams.remove(availableTeams.indexOf(teamNumberOne));
	
			// Choose Second Team
			int teamNumberTwo = getRandomTeam(availableMatchTeams, arraySize);
			teamTwo = fantasyTeams.get(teamNumberTwo).getTeamName();
			chosenMatchTeams.add(teamNumberTwo);
			availableMatchTeams.remove(availableTeams.indexOf(teamNumberTwo));
			
			System.out.println(chosenMatchUps.get(teamNumberOne));
			
			System.out.println(teamOne +" vs. "+ teamTwo);
			
		return chosenMatchTeams;
		
	}


	private int getRandomTeam(ArrayList<Integer> availableMatchTeams, int arraySize) {
		Random rand = new Random();
		int team = rand.nextInt(arraySize);
		String repeat;
	
		do {	
			
			if(availableMatchTeams.contains(team)) {
				repeat = "no";
			}
			else {
				repeat = "yes";
				team = rand.nextInt(arraySize);
			}
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
