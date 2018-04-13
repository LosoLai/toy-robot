package Commands;
import TableTop_Model.ToyRobot;

public class RightCommand extends Command {
	ToyRobot robot = ToyRobot.getInstance();
	
	public RightCommand()
	{
		super(RIGHT);
	}

	@Override
	public void execute() {
		robot.robotTurnRight();
	}
}
