package com.revature.fantasyfootball;

import javax.xml.ws.Endpoint;

public class Application {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8585/FantasyTeams", new ApplicationController());
	}

}
