/**
 * 
 */
package JUnit_Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Commands.PlaceCommand;
import Simulator_Controller.Simulator;
import TableTop_Model.ToyRobot;

/**
 * @author Loso
 *
 */
public class UnitTest_PlaceCommand {
	private final static int PARA_LENGTH = 4;
	private final static int PARA0 = 0;
	private final static int PARA1 = 1;
	private final static int PARA2 = 2;
	private final static int PARA3 = 3;
	private String[] inputs;
	private ToyRobot robot;

	@Before
	public void setUp() throws Exception {
		inputs = new String[PARA_LENGTH];
		
		inputs[PARA0] = "PLACE";
		inputs[PARA1] = "0";
		inputs[PARA2] = "0";
		inputs[PARA3] = "NORTH";
	}
	
	/**
	 * Test the double place commands 
	 * @throws Exception 
	 */
	@Test
	public void test_Double_PlaceCommand() throws Exception
	{
		//first place command
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.isExecutableFlag());
		if(command.isExecutableFlag())
			command.execute();
		
		//expected value: 1
		robot = ToyRobot.getInstance();
		int nExpect = 1;
		int nActual = Simulator.getInstance().getPlaceCounter();
		assertEquals(nExpect, nActual);
		
		//second place command
		inputs[PARA1] = "2";
		inputs[PARA2] = "2";
		command = new PlaceCommand(inputs);
		assertTrue(command.isExecutableFlag());
		if(command.isExecutableFlag())
			command.execute();
		
		//expected value: 2
		nExpect = 2;
		nActual = Simulator.getInstance().getPlaceCounter();
		assertEquals(nExpect, nActual);	
	}
	
	/**
	 * Test the PositionX validation
	 * @throws CommandParametersNotFit 
	 */
	@Test
	public void test_PARA1_PosX() {
		// test cases: PLACE 0 0 NORTH
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA1] = "1";
		//test cases: PLACE 1 0 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 1);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA1] = "2";
		//test cases: PLACE 2 0 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 2);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA1] = "3";
		//test cases: PPLACE 3 0 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 3);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA1] = "4";
		//test cases: PPLACE 4 0 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 4);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		//out of range conditions
		inputs[PARA1] = "5";
		//test cases: PPLACE 5 0 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 5);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertFalse(command.isExecutableFlag());
		
		inputs[PARA1] = "-1";
		//test cases: PPLACE -1 0 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == -1);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertFalse(command.isExecutableFlag());
	}
	
	/**
	 * Test the PositionY validation
	 * @throws CommandParametersNotFit 
	 */
	@Test
	public void test_PARA2_PosY() {
		// test cases: PLACE 0 0 NORTH
		PlaceCommand command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 0);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA2] = "1";
		//test cases: PLACE 0 1 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 1);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA2] = "2";
		//test cases: PLACE 0 2 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 2);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA2] = "3";
		//test cases: PPLACE 0 3 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 3);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		inputs[PARA2] = "4";
		//test cases: PPLACE 0 4 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 4);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertTrue(command.isExecutableFlag());
		
		//out of range conditions
		inputs[PARA2] = "5";
		//test cases: PPLACE 0 5 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == 5);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertFalse(command.isExecutableFlag());
		
		inputs[PARA2] = "-1";
		//test cases: PPLACE 0 -1 NORTH
		command = new PlaceCommand(inputs);
		assertTrue(command.getPara0_Type() == PlaceCommand.PLACE);
		assertTrue(command.getPara1_posX() == 0);
		assertTrue(command.getPara2_posY() == -1);
		assertTrue(command.getPara3_Facing() == "NORTH");
		assertFalse(command.isExecutableFlag());
	}

}
