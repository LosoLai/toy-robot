package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.RightCommand;
import TableTop_Model.ToyRobot;
import Commands.PlaceCommand;

public class UnitTest_RightCommand {
	private ToyRobot robot;

	@Before
	public void setUp() throws Exception {		
		//place robot first
		robot = ToyRobot.getInstance();
		robot.setPosX(2);
		robot.setPosY(2);
		robot.setFacing("NORTH");
	}

	/**
	 * Test the left commands
	 * Starting point 2,2 facing south
	 */
	@Test
	public void test_TurnRight()
	{		
		//expected: face east
		RightCommand left = new RightCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("EAST", robot.getFacing());
		
		//expected: face south
		left = new RightCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("SOUTH", robot.getFacing());
		
		//expected: face west
		left = new RightCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("WEST", robot.getFacing());
		
		//expected: face notrh
		left = new RightCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("NORTH", robot.getFacing());
		
		//expected: face east
		left = new RightCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("EAST", robot.getFacing());
		
		//expected: face south
		left = new RightCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("SOUTH", robot.getFacing());
	}
}
