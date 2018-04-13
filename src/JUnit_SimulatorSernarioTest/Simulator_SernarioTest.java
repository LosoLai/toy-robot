package JUnit_SimulatorSernarioTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CostomizedExceptions.CommandNotExistException;
import Simulator_Controller.Simulator;
import TableTop_Model.ToyRobot;

public class Simulator_SernarioTest {
	private static Simulator simulator;
	private static ToyRobot robot;
	private String[] inputs;
	private ArrayList<String> sernario;
	
	@Before
	public void setUp() throws Exception {
		simulator = Simulator.getInstance();
		sernario = new ArrayList<String>();
	}

	@Test
	public void test_ExampleA() {
		sernario.clear();
		sernario.add("PLACE 0,0,NORTH");
		sernario.add("MOVE");
		sernario.add("REPORT");
		
		for(int i=0 ; i<sernario.size() ; i++)
		{
			String str = sernario.get(i);
			inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
			
			boolean bResult = true;
			try {
				bResult = simulator.excuteInput(inputs);
			} catch (CommandNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(bResult);
		}
		
		robot = ToyRobot.getInstance();
		//expected:
		//0,1,NORTH
		assertEquals(0, robot.getPosX());
		assertEquals(1, robot.getPosY());
		assertEquals("NORTH", robot.getFacing());
	}
	
	@Test
	public void test_ExampleB() {
		sernario.clear();
		sernario.add("LEFT");
		sernario.add("REPORT");
		
		for(int i=0 ; i<sernario.size() ; i++)
		{
			String str = sernario.get(i);
			inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
			
			boolean bResult = true;
			try {
				bResult = simulator.excuteInput(inputs);
			} catch (CommandNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(bResult);
		}
		
		robot = ToyRobot.getInstance();
		//expected:
		//0,1,WEST
		assertEquals(0, robot.getPosX());
		assertEquals(1, robot.getPosY());
		assertEquals("WEST", robot.getFacing());
	}
	
	@Test
	public void test_ExampleC() {
		sernario.clear();
		sernario.add("MOVE");
		sernario.add("MOVE");
		sernario.add("LEFT");
		sernario.add("MOVE");
		sernario.add("REPORT");
		
		for(int i=0 ; i<sernario.size() ; i++)
		{
			String str = sernario.get(i);
			inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
			
			boolean bResult = true;
			try {
				bResult = simulator.excuteInput(inputs);
			} catch (CommandNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(bResult);
		}
		
		robot = ToyRobot.getInstance();
		//expected:
		//0,0,SOUTH
		assertEquals(0, robot.getPosX());
		assertEquals(0, robot.getPosY());
		assertEquals("SOUTH", robot.getFacing());
	}

}
