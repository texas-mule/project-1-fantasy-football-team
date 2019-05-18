package com.revature.fantasyfootball;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

// Create Connection with DataBase
public class DataConnect {
	
	int teamCounter;
	
	// Retrieve League Information Function
	public ArrayList<FantasyTeam> retrieveLeagueInformation() {
		// Create Array To Hold Fantasy League
		ArrayList<FantasyTeam> fantasyLeagueInformation = new ArrayList<>();
		
		// DataBase Information
		String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/wzdpteqa";
		String username = "wzdpteqa";
		String password = "Zvy785zIsosVoVrrPpnOxfRQBBlIki_u";
		
		// Test For Driver
		try { 
			Class.forName("org.postgresql.Driver");
	    } catch (java.lang.ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	      }
		
		// Pull Teams From DataBase
		try {
			// Establish Connection
			Connection database = DriverManager.getConnection(url, username, password);
			// Initialize SQL Statement
			Statement statement = database.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM league ORDER BY rank");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			// While Additional Data Exists
			while(resultSet.next()) {
				// Initialize Team Count
				teamCounter= resultSetMetaData.getColumnCount();
				// Create Team
				FantasyTeam team = new FantasyTeam();
				// Populate Team Data
				team.setTeamID(resultSet.getInt(1));
				team.setTeamName(resultSet.getString(2));
				team.setTeamRank(resultSet.getInt(3));
				team.setTeamFPS(resultSet.getBigDecimal(4));
				team.setTeamWins(resultSet.getInt(5));
		    	team.setTeamLoss(resultSet.getInt(6));
		    	// Add Team To League
		    	fantasyLeagueInformation.add(team);
			}
			
			// Close DataBase
			database.close();
		// If DataBase Cannot Connect, Print Error
		}catch (java.sql.SQLException e) {
			System.out.println("Cannot Connect To League Database");
		}
		
		// Return Fantasy League Information
		return fantasyLeagueInformation;
	}

	public int getTeamCounter() {
		return teamCounter;
	}
}

