package com.revature.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class TeamScores {

private String team;
private double score;
public String getTeam() {
	return team;
}
public void setTeam(String team) {
	this.team = team;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
@Override
public String toString() {
	return "TeamScores [team=" + team + ", score=" + score + "]";
}


}