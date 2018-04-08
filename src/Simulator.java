/**
 * Responsibilities:
 * Simulator reports toy robot movements on a square table top. 
 * The table is 5 X 5 units that no other obstructions on the surface.
 */
public class Simulator {
	public final static int UNIT_SIZE = 5;
	public final static String PLACE  = "PLACE";
	public final static String MOVE   = "MOVE";
	public final static String LEFT   = "LEFT";
	public final static String RIGHT  = "RIGHT";
	public final static String REPORT = "REPORT";
	public final static String EXIT   = "EXIT";
	
	private TableItem[][] table;
	private ToyRobot robot;
	
	// constructor
	// initial table and robot instance
	public Simulator()
	{
		table = new TableItem[UNIT_SIZE][UNIT_SIZE];
		robot = null;
	}
	
	public boolean excuteInput(String[] inputs)
	{
		boolean bExcuted = false;
		if(inputs.length <= 0)
			return bExcuted;
		
		switch(inputs[0])
		{
			case PLACE:
				System.out.println(PLACE);
				break;
			case MOVE:
				System.out.println(MOVE);
				break;
			case LEFT:
				System.out.println(LEFT);
				break;
			case RIGHT:
				System.out.println(RIGHT);
				break;
			case REPORT:
				System.out.println(REPORT);
				break;
			case EXIT:
			default:
				return false;
		}
		
		bExcuted = true;
//		for(int i=0 ; i<inputs.length ; i++)
//		{
//			System.out.println(inputs[i]);
//		}
		return bExcuted;
	}
	
}
