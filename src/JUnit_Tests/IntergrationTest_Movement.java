package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.*;
import TableTop_Model.ToyRobot;

public class IntergrationTest_Movement {
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
	 * Test the movement
	 * Starting point 2,2 facing north
	 * test plan:
	 * 1. move one step
	 * 2. turn right
	 * 3. repeat 4 times
	 */
	@Test
	public void test_Movement1()
	{
		//1.Move
		//expected:
		//posX = 2
		//posY = 3
		//face = north
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(2, robot.getPosX());
		assertEquals(3, robot.getPosY());
		assertEquals("NORTH", robot.getFacing());
		ReportCommand report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
		
		//2.TurnRight
		//expected:
		//posX = 2
		//posY = 3
		//face = east
		RightCommand right = new RightCommand();
		if(right.isExecutableFlag())
			right.execute();
		assertEquals(2, robot.getPosX());
		assertEquals(3, robot.getPosY());
		assertEquals("EAST", robot.getFacing());
		report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
	}
	
	@Test
	public void test_Movement2()
	{
		//1.Move
		//expected:
		//posX = 3
		//posY = 3
		//face = east
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(3, robot.getPosX());
		assertEquals(3, robot.getPosY());
		assertEquals("EAST", robot.getFacing());
		ReportCommand report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
		
		//2.TurnRight
		//expected:
		//posX = 3
		//posY = 3
		//face = south
		RightCommand right = new RightCommand();
		if(right.isExecutableFlag())
			right.execute();
		assertEquals(3, robot.getPosX());
		assertEquals(3, robot.getPosY());
		assertEquals("SOUTH", robot.getFacing());
		report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
	}
	
	@Test
	public void test_Movement3()
	{
		//1.Move
		//expected:
		//posX = 3
		//posY = 2
		//face = south
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(3, robot.getPosX());
		assertEquals(2, robot.getPosY());
		assertEquals("SOUTH", robot.getFacing());
		ReportCommand report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
		
		//2.TurnRight
		//expected:
		//posX = 3
		//posY = 2
		//face = west
		RightCommand right = new RightCommand();
		if(right.isExecutableFlag())
			right.execute();
		assertEquals(3, robot.getPosX());
		assertEquals(2, robot.getPosY());
		assertEquals("WEST", robot.getFacing());
		report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
	}
	
	@Test
	public void test_Movement4()
	{
		//1.Move
		//expected:
		//posX = 2
		//posY = 2
		//face = west
		MoveCommand move = new MoveCommand();
		if(move.isExecutableFlag())
			move.execute();
		assertEquals(2, robot.getPosX());
		assertEquals(2, robot.getPosY());
		assertEquals("WEST", robot.getFacing());
		ReportCommand report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
		
		//2.TurnRight
		//expected:
		//posX = 2
		//posY = 2
		//face = north
		RightCommand right = new RightCommand();
		if(right.isExecutableFlag())
			right.execute();
		assertEquals(2, robot.getPosX());
		assertEquals(2, robot.getPosY());
		assertEquals("NORTH", robot.getFacing());
		report = new ReportCommand();
		if(report.isExecutableFlag())
			report.execute();
	}
}
