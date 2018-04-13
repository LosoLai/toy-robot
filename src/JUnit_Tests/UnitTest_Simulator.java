package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Commands.Command;
import Commands.PlaceCommand;
import CostomizedExceptions.CommandNotExistException;
import Simulator_Controller.Simulator;

public class UnitTest_Simulator {
	private final static int PARA_LENGTH = 4;
	private final static int PARA0 = 0;
	private final static int PARA1 = 1;
	private final static int PARA2 = 2;
	private final static int PARA3 = 3;
	private String[] inputs;
	
	private static Simulator simulator;
	private Command command;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		simulator = Simulator.getInstance();
	}

	@Before
	public void setUp() throws Exception {
		inputs = new String[PARA_LENGTH];
		inputs[PARA0] = "PLACE";
		inputs[PARA1] = "0";
		inputs[PARA2] = "0";
		inputs[PARA3] = "NORTH";
		
		command = null;
	}

	/**
	 * Test the excuteInput function
	 * inputs: [PLACE 0 0 NORTH]
	 */
	@Test
	public void test_excuteInput_Place() throws CommandNotExistException {
		boolean bResult = simulator.excuteInput(inputs);
		assertTrue(bResult);
		
		//check the command type
		//expected:Command.PLACE
		command = simulator.getCommand();
		assertTrue(command instanceof PlaceCommand);
	}
	
	/**
	 * Test the excuteInput function
	 * inputs: [MOVE 0 0 NORTH]
	 * won't throw exception
	 * display warring message for direction
	 */
	@Test
	public void test_excuteInput_MoveWithoutPlace() throws CommandNotExistException {
		inputs[PARA0] = "MOVE";
		boolean bResult = simulator.excuteInput(inputs);
		assertTrue(bResult);
	}
	
	/**
	 * Test the excuteInput function
	 * invalid command type
	 * inputs: [WERTY 0 0 NORTH]
	 */
	@Test(expected = CommandNotExistException.class)
	public void test_excuteInput_Exception() throws CommandNotExistException {
		inputs[PARA0] = "WERTY";
		boolean bResult = simulator.excuteInput(inputs);
	}
}
