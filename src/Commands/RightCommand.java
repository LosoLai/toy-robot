package Commands;
import TableTop.ToyRobot;

public class RightCommand extends Command {
	ToyRobot robot = ToyRobot.getInstance();
	
	public RightCommand()
	{
		super(RIGHT);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		robot.robotTurnRight();
		
		//for debug purpose
		//System.out.println(RIGHT);
		//System.out.println("TURNRIGHT" + " current facing:" + robot.getFacing());
	}
}
