package Commands;
import TableTop_Model.ToyRobot;

public class MoveCommand extends Command {
	ToyRobot robot = ToyRobot.getInstance();
	
	public MoveCommand()
	{
		super(MOVE);
			
		if(!robot.isAbleToMove())
			super.setExecutableFlag(false);
	}

	@Override
	public void execute() {
		robot.robotMove();
	}
}
