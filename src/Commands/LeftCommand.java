package Commands;
import TableTop_Model.ToyRobot;

public class LeftCommand extends Command {
	public final static String LEFT = "LEFT";
	ToyRobot robot = ToyRobot.getInstance();
	
	public LeftCommand()
	{
		super(LEFT);
	}

	@Override
	public void execute() {		
		robot.robotTurnLeft();
	}
}
