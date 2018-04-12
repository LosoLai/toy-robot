package JUnit_CommandTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.LeftCommand;
import Commands.PlaceCommand;
import TableTop_Model.ToyRobot;

public class UnitTest_LeftCommand {
	private final static int PARA_LENGTH = 4;
	private final static int PARA0 = 0;
	private final static int PARA1 = 1;
	private final static int PARA2 = 2;
	private final static int PARA3 = 3;
	private String[] inputs;
	private ToyRobot robot;

	@Before
	public void setUp() throws Exception {
		//place robot first
		inputs = new String[PARA_LENGTH];
		inputs[PARA0] = "PLACE";
		inputs[PARA1] = "2";
		inputs[PARA2] = "2";
		inputs[PARA3] = "NORTH";
						
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.isExecutableFlag());
		if(command.isExecutableFlag())
			command.execute();
						
		robot = ToyRobot.getInstance();
	}

	/**
	 * Test the left commands
	 * Starting point 2,2 facing north
	 */
	@Test
	public void test_TurnLeft()
	{
		//expected: face west
		LeftCommand left = new LeftCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("WEST", robot.getFacing());
		
		//expected: face south
		left = new LeftCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("SOUTH", robot.getFacing());
		
		//expected: face east
		left = new LeftCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("EAST", robot.getFacing());
		
		//expected: face notrh
		left = new LeftCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("NORTH", robot.getFacing());
		
		//expected: face west
		left = new LeftCommand();
		if(left.isExecutableFlag())
			left.execute();
		//position X
		assertEquals(2, robot.getPosX());
		//position Y
		assertEquals(2, robot.getPosY());
		//facing
		assertEquals("WEST", robot.getFacing());
		
		//expected: face south
		left = new LeftCommand();
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
