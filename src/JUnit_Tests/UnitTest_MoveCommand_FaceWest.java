package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.MoveCommand;
import Commands.PlaceCommand;
import TableTop_Model.ToyRobot;

public class UnitTest_MoveCommand_FaceWest {
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
		inputs[PARA3] = "WEST";
						
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.isExecutableFlag());
		if(command.isExecutableFlag())
			command.execute();
						
		robot = ToyRobot.getInstance();
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
