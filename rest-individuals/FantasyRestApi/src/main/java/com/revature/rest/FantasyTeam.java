package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/team")
public class FantasyTeam {
	@GET
	@Path("/{team}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> team(@PathParam("team") String team) {
		PlayerImp playersImp=new PlayerImp();
		List<Player> players=new ArrayList<Player>();
		List<Player> p_player=new ArrayList<Player>();
		Player p=new Player();
		players=playersImp.getAllPlayers();
		for(Player player:players){
			if(player.getF_team().equals(team)){
				p_player.add(player);
				
			}
		}
		return p_player;
	}

}
