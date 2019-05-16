package com.revature.fantasyfootball;

import javax.xml.ws.Endpoint;

public class TeamPublisher {
	
	public static void main(String[] args) {
<<<<<<< HEAD
		Endpoint.publish("http://localhost:8080/FantasyTeams", new TeamService());
=======
		Endpoint.publish("http://localhost:8585/FantasyTeams", new TeamService());
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
	}

}
