package com.revature.fantasyfootball;

<<<<<<< HEAD
import javax.jws.WebService;

@WebService
public class TeamService {
	
	public void displayTeams() {
		
		DataConnect.retrieveTeams();
	}

=======
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.swing.text.html.HTMLDocument.Iterator;

@WebService
 public class TeamService {
	
	@WebMethod
	public ArrayList<fantasyTeam> displayTeams() {
		ArrayList<fantasyTeam> fantasyTeams = new ArrayList<fantasyTeam>();
		DataConnect display = new DataConnect();
		
		fantasyTeams = display.retrieveTeams();	
		return fantasyTeams;
	}
	
	@WebMethod
	public void simSeason() {
		week firstWeek = new week();
		firstWeek.simulateWeek();
	}
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
}
