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
		ArrayList<TeamScores> teamScores=new ArrayList();
		List<String> teams=new ArrayList<>();
		HashMap<String, BigDecimal> hashmap=new HashMap();
		List<Player> players=new ArrayList<>();
		SimWeek simweek=new SimWeek();
		PlayerImp playerImp=new PlayerImp();
		players=simweek.getAllPlayers();
		for(Player p:players){
			if(!teams.contains(p.getF_team())){
				teams.add(p.getF_team());
			}
			
		}
		for(String p:teams){
			TeamScores teas=new TeamScores();
			teas.setTeam(p);
			teamScores.add(teas);
			
			
		}
		
		for(TeamScores t:teamScores){
			for(Player p:players){
				if(t.getTeam().equals(p.getF_team())){
					
					double temp=p.getFps();
					temp=temp+t.getScore();
					t.setScore(temp);
					
					
				}
			}
		}
		TeamScoresFormat teamScoreFormat =  new TeamScoresFormat(teamScores);
		Gson gson=new Gson();
		String jsonString = gson.toJson(teamScoreFormat);
		return Response.status(Response.Status.OK).entity(jsonString).build();
		
	}
}
