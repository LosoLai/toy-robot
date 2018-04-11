package TableTop;
import Commands.*;
import ErrorMessages.*;

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
		
		String upperStr = inputs[0].toUpperCase();
		if(upperStr.matches(PLACE))
			command = new PlaceCommand(inputs);
		else if(upperStr.matches(EXIT))
			return false;
		else
		{
			robot = ToyRobot.getInstance();
			if(robot == null)
			{
				RobotRelated.displayRobotIsNullMessage();
				return true;
			}
			
			if(upperStr.matches(MOVE))
				command = new MoveCommand();
			if(upperStr.matches(LEFT))
				command = new LeftCommand();
			if(upperStr.matches(RIGHT))
				command = new RightCommand();
			if (upperStr.matches(REPORT))
				command = new ReportCommand();
		}
		
		//which means the command type doesn't match any
		//should new exception for it
		//instead of returning false
		if(command == null)
			return false;
		
		command.execute();
		bExcuted = true;

		return bExcuted;
	}
}
