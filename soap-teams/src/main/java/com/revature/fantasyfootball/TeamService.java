package com.revature.fantasyfootball;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.swing.text.html.HTMLDocument.Iterator;

@WebService
 public class TeamService {
	
	@WebMethod
	public void displayTeams() {
		ArrayList<fantasyTeam> fantasyTeams = new ArrayList();
		DataConnect display = new DataConnect();
		fantasyTeams = display.retrieveTeams();
		java.util.Iterator<fantasyTeam> teamIterator = fantasyTeams.iterator();
		
		System.out.println("Current Teams Include: ");
		
		while(teamIterator.hasNext()) {
			System.out.println(teamIterator.next().getTeamName() + " ");
		}
		
	}
	
	@WebMethod
	public void simSeason() {
		week firstWeek = new week();
		firstWeek.simulateWeek();
	}
}
