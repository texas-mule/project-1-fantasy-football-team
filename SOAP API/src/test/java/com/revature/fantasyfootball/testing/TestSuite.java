package com.revature.fantasyfootball.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.revature.fantasyfootball.testing.league.TestingLeague;
import com.revature.fantasyfootball.testing.league.TestingTeam;
import com.revature.fantasyfootball.testing.simulation.TestingGame;
import com.revature.fantasyfootball.testing.simulation.TestingMatchUp;
import com.revature.fantasyfootball.testing.simulation.TestingSeason;
import com.revature.fantasyfootball.testing.simulation.TestingWeek;


@RunWith(Suite.class)
@Suite.SuiteClasses({TestingTeam.class, TestingLeague.class, TestingMatchUp.class,
					TestingGame.class, TestingWeek.class, TestingSeason.class})
public class TestSuite {

	
}
