package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Commands.*;
import CostomizedExceptions.CommandNotExistException;
import Simulator_Controller.Simulator;

public class UnitTest_SimulatorWithPlaceFirst {
	private final static int PARA_LENGTH = 1;
	private final static int PARA0 = 0;
	private static String[] place = {"PLACE", "0", "0", "NORTH"};
	private String[] inputs;
	
	private static Simulator simulator;
	private Command command;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		simulator = Simulator.getInstance();
		boolean bResult = simulator.excuteInput(place);
		assertTrue(bResult);
	}

	@Before
	public void setUp() throws Exception {
		inputs = new String[PARA_LENGTH];		
		command = null;
	}

	/**
	 * Test the excuteInput function
	 * inputs: [MOVE]
	 */
	@Test
	public void test_excuteInput_1() throws CommandNotExistException {
		inputs[PARA0] = "MOVE";
		boolean bResult = simulator.excuteInput(inputs);
		assertTrue(bResult);
		
		//check the command type
		//expected:MoveCommand
		command = simulator.getCommand();
		assertTrue(command instanceof MoveCommand);
	}
	
	/**
	 * Test the excuteInput function
	 * inputs: [LEFT]
	 */
	@Test
	public void test_excuteInput_2() throws CommandNotExistException {
		inputs[PARA0] = "LEFT";
		boolean bResult = simulator.excuteInput(inputs);
		assertTrue(bResult);
		
		//check the command type
		//expected:LeftCommand
		command = simulator.getCommand();
		assertTrue(command instanceof LeftCommand);
	}
	
	/**
	 * Test the excuteInput function
	 * inputs: [RIGHT]
	 */
	@Test
	public void test_excuteInput_3() throws CommandNotExistException {
		inputs[PARA0] = "RIGHT";
		boolean bResult = simulator.excuteInput(inputs);
		assertTrue(bResult);
		
		//check the command type
		//expected:RightCommand
		command = simulator.getCommand();
		assertTrue(command instanceof RightCommand);
	}
	
	/**
	 * Test the excuteInput function
	 * inputs: [REPORT]
	 */
	@Test
	public void test_excuteInput_4() throws CommandNotExistException {
		inputs[PARA0] = "REPORT";
		boolean bResult = simulator.excuteInput(inputs);
		assertTrue(bResult);
		
		//check the command type
		//expected:ReportCommand
		command = simulator.getCommand();
		assertTrue(command instanceof ReportCommand);
	}

}
