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
		else
			forceStringsToUpperCase(inputs);
			
		String upperStr = inputs[0].toUpperCase();
		if(upperStr.matches(EXIT))
			return false;
		else if(upperStr.matches(PLACE))
			command = new PlaceCommand(inputs);
		else
		{
			int nPlaceCounter = getPlaceCounter();
			if(nPlaceCounter < PlaceCommand.PLACE_LIMIT)
			{
				RobotRelated.displayRobotIsNullMessage();
				return true;
			}

			delegateCommands(upperStr);
		}
		
		command.execute();
		bExcuted = true;

		return bExcuted;
	}
	
	// Keep output format consistency
	private void forceStringsToUpperCase(String[] inputs)
	{
		for(int i=0 ; i<inputs.length ; i++)
			inputs[i] = inputs[i].toUpperCase();
	}
	
	private void delegateCommands(String upperStr) throws CommandNotExistException
	{
		if(upperStr.matches(MOVE))
			command = new MoveCommand();
		else if(upperStr.matches(LEFT))
			command = new LeftCommand();
		else if(upperStr.matches(RIGHT))
			command = new RightCommand();
		else if(upperStr.matches(REPORT))
			command = new ReportCommand();
		else
			//which means the command type doesn't match any
			throw new CommandNotExistException("The command is invalid.");
	}
}
