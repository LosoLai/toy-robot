package JUnit_CommandTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.MoveCommand;
import Commands.PlaceCommand;
import TableTop_Model.ToyRobot;

public class UnitTest_MoveCommand_FaceNorth {
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
		inputs[PARA1] = "0";
		inputs[PARA2] = "0";
		inputs[PARA3] = "NORTH";
		
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.isExecutableFlag());
		if(command.isExecutableFlag())
			command.execute();
		
		robot = ToyRobot.getInstance();
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
