package com.revature.fantasyfootball.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.fantasyfootball.league.League;
import com.revature.fantasyfootball.league.Team;

// Create An Object To Represent DAO
public class DatabaseAccess {

/**************************************************************************************/
/********** FIELDS ********************************************************************/
/**************************************************************************************/
	
	// Database Access Fields
	
		// Prepared Statement
			private PreparedStatement preparedStatement;
	
		// SQL Injection
			private String sqlInjection;
			
		// Error Message
			String errorMessage;
			
/**************************************************************************************/
/********** GETTERS AND SETTERS *******************************************************/
/**************************************************************************************/
			
	// Database Access Getters and Setters
			
		// Prepared Statement
			public PreparedStatement getPreparedStatement() {
				return preparedStatement;
			}

			public void setPreparedStatement(PreparedStatement preparedStatement) {
				this.preparedStatement = preparedStatement;
			}

		// SQL Injection
			public String getSqlInjection() {
				return sqlInjection;
			}

			public void setSqlInjection(String sqlInjection) {
				this.sqlInjection = sqlInjection;
			}
			
/***************************************************************************************/
/********** METHODS ********************************************************************/
/***************************************************************************************/	
			
	// Database Access Methods
			
		// Create
			public void createLeagueTable(String leagueName, ArrayList<String >teamNames, League newLeague) {
				
				// Parameters
					
					// Connection
						DatabaseConnection createConnection = new DatabaseConnection();
						
					// SQL Injection
						this.setSqlInjection("CREATE TABLE " + leagueName
								+ "(	teamid   	SERIAL PRIMARY KEY, "
								+	"	teamname  	TEXT,"
								+	"	teamrank	INTEGER NOT NULL DEFAULT 0,"
								+	"	teamwinstat	INTEGER NOT NULL DEFAULT 0,"
								+	"	teamlossstat	INTEGER  NOT NULL DEFAULT 0);");
						
				// Implementation
						
					
						try {
							// Create League
							
								// Error Update
									errorMessage = "\n-CANNOT_CREATE_LEAGUE-\n" 
											+  "-LEAGUE_ALREADY_EXISTS-";
								
								System.out.println("\n-CREATING_LEAGUE-\n");
								
								// Set Connection
									createConnection.connectToLeagueDatabase();
									
								// Create Statement
									Statement statement = createConnection.getConnection().createStatement();
									
								// Execute Statement
									statement.execute(this.sqlInjection);

			
							
							// Insert Teams
									
								// Error Update
									errorMessage = "-CANNOT_INSERT_TEAMS-\n ";
									
								System.out.println("\n-CREATING_TEAMS-\n");
								
								// Prepare and Execute Statement
									for(String team:teamNames) {
										this.setSqlInjection("INSERT INTO " + leagueName
													+ "(teamname)"
													+ "VALUES (?)");
										
										preparedStatement = createConnection.getConnection().prepareStatement(sqlInjection);
										
										preparedStatement.setString(1,team);
										
										// Execute Statement
											preparedStatement.executeUpdate();
									}
							
							// Close Database Connection
									
								// Error Update
									errorMessage = "-CANNOT_CLOSE_CONNECTION-\n";
									
								createConnection.getConnection().close();
							
							// Set League Name
								newLeague.setLeagueName(leagueName);
								
						} catch (Exception e) {
							System.out.println(errorMessage);
						}
				
			}
			
		// Read
			public void readLeague(League league) {
				
				// Parameters
				
					// Connection
						DatabaseConnection readConnection = new DatabaseConnection();
						readConnection.connectToLeagueDatabase();
						
					// SQL Injection
						this.setSqlInjection("SELECT * FROM " + league.getLeagueName());
						
					// ResultSet
						ResultSet resultData = null;
						
					
						
				// Implementation
						
					// Update Prepared Statement
						try {
							System.out.println("-LOCATING_LEAGUE-");
							System.out.println(this.sqlInjection);
							
							this.setPreparedStatement(readConnection.getConnection().prepareStatement(this.sqlInjection));
						} catch (SQLException e) {
							System.out.println("CANNOT_LOCATE_LEAGUE");
							e.printStackTrace();
						}
						
					// Execute 
						try {
							resultData = this.preparedStatement.executeQuery();
							
						} catch (SQLException e) {
							System.out.println("-CANNOT_EXECUTE_PREPARED_STATEMENT-");
							e.printStackTrace();
						}
						
					// Initialize League
						try {
							while(resultData.next()) {
								Team teamCreation = new Team();
								
								// Team ID
									teamCreation.setTeamID(resultData.getInt("teamid"));
									System.out.println("-ADDING_TEAM_NUMBER_"+ teamCreation.getTeamID()+"-");
								
								// Team Name
									teamCreation.setTeamName(resultData.getString("teamname"));
									System.out.println("    -TEAM_NAME_"+ teamCreation.getTeamName()+ "-");

								// Team Rank
									teamCreation.setTeamRank(resultData.getInt("teamrank"));
									System.out.println("    -TEAM_RANK_"+ teamCreation.getTeamRank()+ "-");
									
								// Team Win Stat
									teamCreation.setTeamWinStat(resultData.getInt("teamwinstat"));
									System.out.println("    -TEAM_WINS_"+ teamCreation.getTeamName()+ "-");
								
								// Team Loss Stat
									teamCreation.setTeamLossStat(resultData.getInt("teamlossstat"));
									System.out.println("    -TEAM_WINS_"+ teamCreation.getTeamName()+ "-");
									
								// Add Team to League
									System.out.println(teamCreation.printStats());
									league.getTeams().add(teamCreation);
							
							}
						} catch (SQLException e) {
							System.out.println("-NO_TEAMS_FOUND_IN_DATABASE-");
							e.printStackTrace();
						}
						
					// Close Database
						try {
							readConnection.getConnection().close();
						} catch (SQLException e) {
							System.out.println("-CANNOT_CLOSE_CONNECTION-");
							e.printStackTrace();
						}
			}
			
		// Update
			public void updateLeague(League league) {
				
				// Parameters
				
					// Connection
						DatabaseConnection updateConnection = new DatabaseConnection();
						updateConnection.connectToLeagueDatabase();
						
					// SQL Injection
						this.setSqlInjection(" UPDATE "+ league.getLeagueName() 
											+" SET teamrank=?, teamwinstat=?, teamlossstat=?" 
											+" WHERE teamname = ?;");
					
				
						System.out.println(sqlInjection);
				// Implementation
					
		        try {
		        			
		        	// Update Prepared Statement
		        		this.setPreparedStatement(updateConnection.getConnection().prepareStatement(this.sqlInjection));
			        	for(int i = 0;i<league.getTeams().size();i++) {
				            preparedStatement.setInt(1, league.getTeams().get(i).getTeamRank());
				            preparedStatement.setInt(2, league.getTeams().get(i).getTeamWinStat());
				            preparedStatement.setInt(3, league.getTeams().get(i).getTeamLossStat());
				            preparedStatement.setString(4, league.getTeams().get(i).getTeamName());
				            
				            // Execute
				            	preparedStatement.executeUpdate();
			        	}
			        	
			        // Close Database
			        	updateConnection.getConnection().close();
		 
			  
		        } 
		        
		     // Connection Not Established
		        catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
			}
			
		// Delete
			
		
			
}
