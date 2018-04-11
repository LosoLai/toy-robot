package JUnit_CommandTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import TableTop.Simulator;
import TableTop.ToyRobot;

public class Simulator_SernarioTest_ExampleB {
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
		sernario.add("LEFT");
		sernario.add("REPORT");
	}

	@Test
	public void test() {
		for(int i=0 ; i<sernario.size() ; i++)
		{
			String str = sernario.get(i);
			inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
			
			boolean bResult = simulator.excuteInput(inputs);
			assertTrue(bResult);
		}
		
		robot = ToyRobot.getInstance();
		//expected:
		//0,0,WEST
		assertEquals(0, robot.getPosX());
		assertEquals(0, robot.getPosY());
		assertEquals("WEST", robot.getFacing());
	}

}
