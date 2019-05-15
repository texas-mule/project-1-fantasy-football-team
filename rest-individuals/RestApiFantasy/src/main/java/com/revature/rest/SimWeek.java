package com.revature.rest;


import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/simweek")
public class SimWeek {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> simulate(){
		PlayerImp playersImp=new PlayerImp();
		List<Player> players=playersImp.getAllPlayers();
		for(Player p:players){
			Random rand = new Random();
			double team = rand.nextInt(30);
			
			p.setFps(team);
			
		}
        return players;
		
	}
}
