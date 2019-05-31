package com.revature.fantasyfootball2;

import javax.xml.ws.Endpoint;

public class TeamPublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8585/FantasyTeams", new TeamService());
	}

}
