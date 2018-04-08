/**
 * Responsibilities:
 * Simulator reports toy robot movements on a square table top. 
 * The table is 5 X 5 units that no other obstructions on the surface.
 */
public class Simulator {
	public final static int UNIT_SIZE = 5;
	
	private TableItem[][] table;
	private ToyRobot robot;
	
	// constructor
	// initial table and robot instance
	public Simulator()
	{
		table = new TableItem[UNIT_SIZE][UNIT_SIZE];
		robot = null;
	}
	
	public boolean excuteCommand(String[] inputs)
	{
		boolean bExcuted = false;
		if(inputs.length <= 0)
			return bExcuted;
		
		for(int i=0 ; i<inputs.length ; i++)
		{
			System.out.println(inputs[i]);
		}
		return bExcuted;
	}
}
