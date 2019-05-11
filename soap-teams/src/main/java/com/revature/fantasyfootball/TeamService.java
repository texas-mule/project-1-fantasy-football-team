package com.revature.fantasyfootball;

import javax.jws.WebService;

@WebService
public class TeamService {
	
	public void displayTeams() {
		
		DataConnect.retrieveTeams();
	}

}
