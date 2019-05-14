package com.revature.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class FantasyResourse extends ResourceConfig {
	public FantasyResourse() {
		packages("com.revature.rest");
	}
}
