package Commands;
import TableTop.ToyRobot;

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
		// TODO Auto-generated method stub
			
		robot.robotMove();
		
		//for debug purpose
		System.out.println(MOVE + " current pos:" + 
		robot.getPosX() + ", " + robot.getPosY());
	}
}
