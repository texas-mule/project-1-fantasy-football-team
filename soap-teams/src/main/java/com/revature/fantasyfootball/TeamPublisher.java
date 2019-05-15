package com.revature.fantasyfootball;

import javax.xml.ws.Endpoint;

public class TeamPublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/FantasyTeams", new TeamService());
	}

}
