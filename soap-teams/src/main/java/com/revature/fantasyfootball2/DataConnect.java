package com.revature.fantasyfootball2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// Create Object To Represent DataBase Connection
public class DataConnect {
	
/*******************************************************************************************************************************************/
/**************************************************** CONNECTION FIELDS ********************************************************************/
/*******************************************************************************************************************************************/
	// Connection Fields
		// Database URL
			String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/wzdpteqa";
		// Database Username
			String username = "wzdpteqa";
		// Database Password
			String password = "Zvy785zIsosVoVrrPpnOxfRQBBlIki_u";
		// Team Counter
			int teamCounter;
		// Fantasy League Information
			ArrayList<FantasyTeam> fantasyLeagueInformation = new ArrayList<>();
			
/*******************************************************************************************************************************************/
/********************************************* CONNECTION GETTERS AND SETTERS ***********************************************************/
/*******************************************************************************************************************************************/	
	// Connection Getters and Setters
			
		// Fantasy League Information		
			public ArrayList<FantasyTeam> getFantasyLeagueInformation() {
				return fantasyLeagueInformation;
			}

			public void setFantasyLeagueInformation(ArrayList<FantasyTeam> fantasyLeagueInformation) {
				this.fantasyLeagueInformation = fantasyLeagueInformation;
			}

/*******************************************************************************************************************************************/
/************************************************* CONNECTION FUNCTIONS **************************************************************************/
/*******************************************************************************************************************************************/
			
	// Connection Functions		
			
		// Retrieve League Information Function
			public void retrieveLeagueInformation() {
		
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
							ResultSet resultSet = statement.executeQuery("SELECT * FROM league");
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
									team.setTeamWins(resultSet.getInt(4));
							    	team.setTeamLoss(resultSet.getInt(5));
							    	
						    	// Add Team To League Data
							    	fantasyLeagueInformation.add(team);
							}
						
							// Close DataBase
								database.close();
								
				// If DataBase Cannot Connect, Print Error
					}catch (java.sql.SQLException e) {
						System.out.println("Cannot Connect To League Database");
					}
	}

		// Update League Information Function
			public void updateLeagueInformation(FantasyLeague endOfWeekSubmissionLeague) {
			
				// Method Fields
					
					// Prepared Statement
						PreparedStatement pstmt = null;
						
					// SQL Statement
						String sql="UPDATE league\n" + 
								"	SET rank=?, teamwin=?, teamloss=?" + 
								"	WHERE teamname = ?;";
				
				// Method Implementation
						
			        try {
			        	
			        	// Establish Connection
			        		Connection database = DriverManager.getConnection(url, username, password);
			        			
			        	// Update Prepared Statement
			        		pstmt = database.prepareStatement(sql);
				        	for(int i = 0;i<endOfWeekSubmissionLeague.getNumberOfTeams();i++) {
					            pstmt.setInt(1, endOfWeekSubmissionLeague.getTeams().get(i).getTeamRank());
					            pstmt.setInt(2, endOfWeekSubmissionLeague.getTeams().get(i).getTeamWins());
					            pstmt.setInt(3, endOfWeekSubmissionLeague.getTeams().get(i).getTeamLoss());
					            pstmt.setString(4, endOfWeekSubmissionLeague.getTeams().get(i).getTeamName());
					            
					            // Execute
					            	pstmt.executeUpdate();
				        	}
				        	
				        // Close Database
				        	database.close();
			 
				  
			        } 
			        
			     // Connection Not Established
			        catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }	
				
			}
}

