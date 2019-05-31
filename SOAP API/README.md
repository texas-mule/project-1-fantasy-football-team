# Project One - Fantasy Football SOAP API

Created by Shaun Gordon

A Fantasy Football SOAP API

URL:

http://localhost:8585/FantasyTeams

WSDL:

http://localhost:8585/FantasyTeams?wsdl


SOAP Functions:


- Simulate Single Game 

- Simulate Single Week 

- Simulate Single Season 

--------------------


Functionality:

A Rest API developed by Mohomad Khalifa assigned each player an FPS stat. These stats were summed together according to each team.

This team FPS stat was the output of the REST API and a Mule Flow was executed to transform this JSON message to XML

With an XML input ->

# - Simulate A Single Game :

	- Assigns each team their respective FPS
	- Randomly selects two teams for a game
	- Executes a game where the team with the highest FPS wins
	
# - Simulate A Single Week :

	- Full single game simulation conducted according to maximum number of matches per week
	- Week number is accounted for and incremented
	- After the week is completed, the winners are evaluated according to a WL ratio
	- League Ranks are updated
	
# - Simulate A Single Season :

	- Full week simulation conducted according to the maximum number of weeks per season utilizing a factorial algorithm.
	- Year number is accounted for and is incremented
	- After the season is completed, the League Leader is assigned.
	- League Ranks are updated
 
 