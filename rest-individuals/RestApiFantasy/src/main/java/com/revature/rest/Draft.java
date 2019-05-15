package com.revature.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/draft")
public class Draft {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/{fname}")
	public String draft(@PathParam("id") int id,@PathParam("fteam") String fteam){
		PlayerImp playerImp=new PlayerImp();
		playerImp.draftPlayer(id, fteam);
		return "Draft Successful!";
		
	}

}
