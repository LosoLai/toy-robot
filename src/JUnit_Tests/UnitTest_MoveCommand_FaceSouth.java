package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.MoveCommand;
import Commands.PlaceCommand;
import TableTop_Model.ToyRobot;

public class UnitTest_MoveCommand_FaceSouth {
	private ToyRobot robot;

	@Before
	/**
	 * Starting point 4,4 facing south
	 */
	public void setUp() throws Exception {
		//place robot first
		robot = ToyRobot.getInstance();
		robot.setPosX(4);
		robot.setPosY(4);
		robot.setFacing("SOUTH");
	}

	/**
	 * Test the move commands
	 */
	@Test
	public void test_MoveForward_FacingSouth()
	{		
		int nExpected = 4;	
		//facing south one step forward
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosY());
		
		//facing south one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosY());
		
		//facing south one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosY());
		
		//facing south one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosY());
		
		//out of range
		move = new MoveCommand();
		assertFalse(move.isExecutableFlag());
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(nExpected, robot.getPosY());
	}

}
