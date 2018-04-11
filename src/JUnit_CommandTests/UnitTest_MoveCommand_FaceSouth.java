package JUnit_CommandTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.MoveCommand;
import Commands.PlaceCommand;
import TableTop.ToyRobot;

public class UnitTest_MoveCommand_FaceSouth {
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
		inputs[PARA1] = "4";
		inputs[PARA2] = "4";
		inputs[PARA3] = "SOUTH";
				
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.isExecutableFlag());
		if(command.isExecutableFlag())
			command.execute();
				
		robot = ToyRobot.getInstance();
	}

	/**
	 * Test the move commands
	 * Starting point 4,4 facing south
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
