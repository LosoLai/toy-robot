package Simulator_Controller;
import CostomizedExceptions.CommandNotExistException;
import ErrorMessages_View.*;
import TableTop_Model.ToyRobot;
import Commands.*;

/**
 * Simulator class takes a controller role in the system, apply Singleton pattern
 * Responsibilities:
 * matching certain command type by inputs[0]
 * create the command then execute
 * Simulator class has
 * - a private Command instance
 * - a private int placeCounter
 * - public getInstance()
 * - public getPlaceCounter()
 *   in order to monitor/limited how many times that the executable Place command is executed
 */
public class Simulator {
	public final static String PLACE  = "PLACE";
	public final static String MOVE   = "MOVE";
	public final static String LEFT   = "LEFT";
	public final static String RIGHT  = "RIGHT";
	public final static String REPORT = "REPORT";
	public final static String EXIT   = "EXIT";
	
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
		command = null;
	}
	
	public Command getCommand() {
		return command;
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
		if(upperStr.matches(EXIT))
			return false;
		if(upperStr.matches(PLACE))
			command = new PlaceCommand(inputs);
		if(upperStr.matches(MOVE) ||
		   upperStr.matches(LEFT) ||
		   upperStr.matches(RIGHT) ||
		   upperStr.matches(REPORT))
		{
			int nPlaceCounter = getPlaceCounter();
			if(nPlaceCounter < PlaceCommand.PLACE_LIMIT)
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
		if(command == null)
			throw new CommandNotExistException("The command is invalid.");
		
		command.execute();
		bExcuted = true;

		return bExcuted;
	}
}
