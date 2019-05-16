package com.revature.fantasyfootball;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.fantasyfootball.fantasyTeam;

class DataConnect {
	
	public ArrayList<fantasyTeam> retrieveTeams() {
		
		ArrayList<fantasyTeam> fantasyTeams = new ArrayList<fantasyTeam>();
		
		String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/wzdpteqa";
		String username = "wzdpteqa";
		String password = "Zvy785zIsosVoVrrPpnOxfRQBBlIki_u";
		
			try { 
				Class.forName("org.postgresql.Driver");
		    } catch (java.lang.ClassNotFoundException e) {
		            System.out.println(e.getMessage());
		      }
	
		    try {
		    	Connection db = DriverManager.getConnection(url, username, password);
		        Statement st = db.createStatement();
		        ResultSet rs = st.executeQuery("SELECT * FROM teams ORDER BY rank");
		        while(rs.next()) {
		        	
		    	   int rowIndicator= 1;
		    	   fantasyTeam team = new fantasyTeam();
		    	   team.setTeamIndicator(rs.getInt(1));
		    	   team.setTeamName(rs.getString(2));
		    	   team.setTeamRank(rs.getInt(3));
		    	   team.setTeamWins(rs.getInt(4));
		    	   team.setTeamLoss(rs.getInt(5));
		    	   team.setTeamFPS(rs.getBigDecimal(6));
		        	
		    	   while(rowIndicator==1) {
		    		   fantasyTeams.add(team);
		    		   rowIndicator++;
					}
		        }
		        db.close();
		    } catch (java.sql.SQLException e) {
		            System.out.println(e.getMessage());
		    }
		    
		    return fantasyTeams;
	}

}