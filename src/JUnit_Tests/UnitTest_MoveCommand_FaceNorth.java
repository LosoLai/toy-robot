package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.MoveCommand;
import Commands.PlaceCommand;
import TableTop_Model.ToyRobot;

public class UnitTest_MoveCommand_FaceNorth {
	private ToyRobot robot;

	@Before
	public void setUp() throws Exception {		
		//place robot first
		robot = ToyRobot.getInstance();
		robot.setPosX(0);
		robot.setPosY(0);
		robot.setFacing("NORTH");
	}

	/**
	 * Test the move commands
	 * Starting point 0,0 facing north
	 */
	@Test
	public void test_MoveForward_FacingNorth()
	{			
		int nExpected = 0;	
		//facing north one step forward
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(++nExpected, robot.getPosY());
		
		//facing north one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(++nExpected, robot.getPosY());
		
		//facing north one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(++nExpected, robot.getPosY());
		
		//facing north one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(++nExpected, robot.getPosY());
		
		//out of range
		move = new MoveCommand();
		assertFalse(move.isExecutableFlag());
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(nExpected, robot.getPosY());
	}
}
