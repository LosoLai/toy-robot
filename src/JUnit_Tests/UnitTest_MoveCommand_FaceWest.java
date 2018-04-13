package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.MoveCommand;
import Commands.PlaceCommand;
import TableTop_Model.ToyRobot;

public class UnitTest_MoveCommand_FaceWest {
	private ToyRobot robot;

	@Before
	public void setUp() throws Exception {
		//place robot first
		robot = ToyRobot.getInstance();
		robot.setPosX(4);
		robot.setPosY(4);
		robot.setFacing("WEST");
	}

	/**
	 * Test the move commands
	 * Starting point 4,4 facing west
	 */
	@Test
	public void test_MoveForward_FacingSouth()
	{		
		int nExpected = 4;	
		//facing west one step forward
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosX());
		
		//facing west one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosX());
		
		//facing west one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosX());
		
		//facing west one step forward
		move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(--nExpected, robot.getPosX());
		
		//out of range
		move = new MoveCommand();
		assertFalse(move.isExecutableFlag());
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(nExpected, robot.getPosX());
	}
}
