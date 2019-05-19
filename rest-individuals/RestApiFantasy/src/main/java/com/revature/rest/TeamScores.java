package com.revature.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class TeamScores {

private String teamname;
private double score;
public String getTeam() {
	return teamname;
}
public void setTeam(String team) {
	this.teamname = team;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
@Override
public String toString() {
	return "team:" + teamname + ", score=" + score +" ";
}


}