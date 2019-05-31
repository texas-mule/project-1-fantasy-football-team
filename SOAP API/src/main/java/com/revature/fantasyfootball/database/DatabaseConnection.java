package com.revature.fantasyfootball.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Create An Object To Represent Database Information
public class DatabaseConnection {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/
		
	// Connection Fields
	
			// Database URL
				private String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/wzdpteqa";
				
			// Database Username
				private String username = "wzdpteqa";
				
			// Database Password
				private String password = "Zvy785zIsosVoVrrPpnOxfRQBBlIki_u";
				
			// Connection
				Connection connection = null;
				
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/
				
	// Connection Getters and Setters
				
			// URL
				public String getUrl() {
						return url;
					}
	
				public void setUrl(String url) {
					this.url = url;
				}
				
			// Username
				public String getUsername() {
					return username;
				}

				public void setUsername(String username) {
					this.username = username;
				}

			// Password
				public String getPassword() {
					return password;
				}

				public void setPassword(String password) {
					this.password = password;
				}
			
			// Connection
				public Connection getConnection() {
					return connection;
				}

				public void setConnection(Connection leagueConnection) {
					this.connection = leagueConnection;
				}
			
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/			
	
	// Connection Methods
				
			// Get Connection
				
				public void connectToLeagueDatabase() {
							
					// League Connection Implementation
							
						// Test For Driver
							try {
								Class.forName("org.postgresql.Driver");
						    } 
							
							// Driver Not Found
								catch (java.lang.ClassNotFoundException e) {
									System.out.println("Could Not Locate Driver");
									System.out.println(e.getMessage());
							    }
							
						// Establish Connection
							
							try {
								this.setConnection(DriverManager.getConnection(url, username, password));
								System.out.println("-CONNECTION_ESTABLISHED-");
						    }	
							
							// Connection Not Established
								catch (SQLException ex) {
									System.out.println("Could Not Establish Connection");
									System.out.println(ex.getMessage());
						        }	
				}
				
/***************************************************************************************/
/********** PRINT METHODS **************************************************************/
/***************************************************************************************/		
				
	// Connection Print Methods
				
			// Connection toString();
				@Override
				public String toString() {
					return "DatabaseConnection : "
							+ "\n	url=" + url 
							+ "\n	username=" + username 
							+ "\n	password=" + password;
				}
}
