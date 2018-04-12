package Simulator_Controller;
import CostomizedExceptions.CommandNotExistException;
import ErrorMessages_View.*;
import TableTop_Model.ToyRobot;
import Commands.*;

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
	private int placeCounter;
	
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
	
	public int getPlaceCounter() {
		return placeCounter;
	}

	public void setPlaceCounter() {
		this.placeCounter++;
	}
	
	public boolean excuteInput(String[] inputs) throws CommandNotExistException
	{
		boolean bExcuted = false;
		if(inputs.length <= 0)
			return bExcuted;
		
		String upperStr = inputs[0].toUpperCase();
		if(upperStr.matches(PLACE))
		{
			command = new PlaceCommand(inputs);
		}
		else if(upperStr.matches(EXIT))
			return false;
		else
		{
			int nPlaceCounter = getPlaceCounter();
			if(nPlaceCounter < PlaceCommand.PLACE_LIMIT)
			{
				RobotRelated.displayRobotIsNullMessage();
				return true;
			}
			else
			{
				if(upperStr.matches(MOVE))
					command = new MoveCommand();
				if(upperStr.matches(LEFT))
					command = new LeftCommand();
				if(upperStr.matches(RIGHT))
					command = new RightCommand();
				if (upperStr.matches(REPORT))
					command = new ReportCommand();
			}
		}
		
		//which means the command type doesn't match any
		if(command == null)
			throw new CommandNotExistException("The command is invalid.");
		
		command.execute();
		bExcuted = true;

		return bExcuted;
	}
}
