package Commands;
import TableTop_Model.ToyRobot;

public class LeftCommand extends Command {
	ToyRobot robot = ToyRobot.getInstance();
	
	public LeftCommand()
	{
		super(LEFT);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		robot.robotTurnLeft();
		
		//for debug purpose
		//System.out.println(LEFT);
		//System.out.println("TURNLEFT" + " current facing:" + robot.getFacing());
	}
}
