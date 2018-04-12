package JUnit_CommandTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CostomizedExceptions.CommandNotExistException;
import TableTop.Simulator;
import TableTop.ToyRobot;

public class Simulator_SernarioTest_ExampleA {
	private static Simulator simulator;
	private static ToyRobot robot;
	private String[] inputs;
	private ArrayList<String> sernario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		simulator = Simulator.getInstance();
	}

	@Before
	public void setUp() throws Exception {
		sernario = new ArrayList<String>();
		sernario.add("PLACE 0,0,NORTH");
		sernario.add("MOVE");
		sernario.add("REPORT");
	}

	@Test
	public void test() {
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

}
