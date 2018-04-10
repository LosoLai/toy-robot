import Commands.*;
import ErrorMessages.*;
import TableTop.ToyRobot;

/**
 * Responsibilities:
 * Simulator reports toy robot movements on a square table top. 
 * The table is 5 X 5 units that no other obstructions on the surface.
 */
public class Simulator {
	public final static String PLACE  = "PLACE";
	public final static String MOVE   = "MOVE";
	public final static String LEFT   = "LEFT";
	public final static String RIGHT  = "RIGHT";
	public final static String REPORT = "REPORT";
	public final static String EXIT   = "EXIT";
	
	private ToyRobot robot;
	private Command command;
	private static Simulator instance = null;
	
	public static Simulator getInstance()
	{
		if(instance == null)
			instance = new Simulator();
		
		return instance;
	}
	
	// constructor
	// initial table and robot instance
	private Simulator()
	{
		robot = null;
		command = null;
	}
	
	public boolean excuteInput(String[] inputs)
	{
		boolean bExcuted = false;
		if(inputs.length <= 0)
			return bExcuted;
		
		switch(inputs[0])
		{
			case PLACE:
				command = new PlaceCommand(inputs);
				break;
			case MOVE:
			case LEFT:
			case RIGHT:
			case REPORT:
				{
					if(robot == null)
					{
						RobotRelated.displayRobotIsNullMessage();
						return true;
					}
					
					if(inputs[0] == MOVE)
						command = new MoveCommand();
					else if(inputs[0] == LEFT)
						command = new LeftCommand();
					else if(inputs[0] == RIGHT)
						command = new RightCommand();
					else
						command = new ReportCommand();
				}
				break;
			case EXIT:
			default:
				return false;
		}
		
		//should new expection for it
		//instead of returning false
		if(command == null)
			return false;
		
		command.excute();
		bExcuted = true;

		return bExcuted;
	}
}
