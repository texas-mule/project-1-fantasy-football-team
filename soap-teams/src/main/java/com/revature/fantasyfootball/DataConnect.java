package com.revature.fantasyfootball;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.fantasyfootball.fantasyTeam;
<<<<<<< HEAD
public class DataConnect {
	
	public static void retrieveTeams() {
		
		fantasyTeam team = new fantasyTeam();
		
		ArrayList fantasyTeams = new ArrayList();
=======

class DataConnect {
	
	public ArrayList<fantasyTeam> retrieveTeams() {
		
		ArrayList<fantasyTeam> fantasyTeams = new ArrayList<fantasyTeam>();
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
		
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
<<<<<<< HEAD
		        ResultSet rs = st.executeQuery("SELECT * FROM teams");
		        ResultSetMetaData rsmd = rs.getMetaData();
		        
		       int teamIndicator=0;
		       while(rs.next()) {
		    	   int rowIndicator= 1;
		        	team.setTeamIndicator(rs.getInt(1));
		        	team.setTeamName(rs.getString(2));
		        	team.setTeamRank(rs.getInt(3));
		        	team.setTeamFPS(rs.getBigDecimal(4));
		        	    
					while(rowIndicator==1) {
		            	fantasyTeams.add(team.getTeamRank());
		            	fantasyTeams.add(team.getTeamName());
		            	fantasyTeams.add(team.getTeamFPS());
		            	rowIndicator++;
					}
					
		            System.out.println();
		            teamIndicator++;
		       }
		       for(int printer = 0; printer<=teamIndicator*2;printer=printer +3) {
		       	System.out.println(fantasyTeams.subList(printer, printer+3));	
		       }
		        rs.close();
		        st.close();
		    } catch (java.sql.SQLException e) {
		            System.out.println(e.getMessage());
		      }
=======
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
>>>>>>> fe434bb5f397172f6cc8843347788616860320c5
	}

}
