package com.revature.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/scores")
public class FantasyPoints {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response scores(){
		List<BigDecimal> list=new ArrayList<>();
		SimWeek simweek=new SimWeek();
		HashMap<String,Double> hashmap=new HashMap();
		List<Player> players=simweek.getAllPlayers();
		for(Player p:players){
			hashmap.put(p.getF_team(), 0.0);
			
		}
		for(Player p:players){
			double temp=hashmap.get(p.getF_team());
			temp+=p.getFps();
			hashmap.put(p.getF_team(),temp);
			
		}
		for(Player p:players){
			
			BigDecimal temp=new BigDecimal(hashmap.get(p.getF_team()));
			if(!list.contains(temp.setScale(2, 4))){
			list.add(temp.setScale(2, 4));
			}
			
		}
		Gson gson=new Gson();
		String jsonString = gson.toJson(list);
		return Response.status(Response.Status.OK).entity(jsonString).build();
		
	}
}
