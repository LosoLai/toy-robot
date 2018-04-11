package Commands;
import TableTop.ToyRobot;

public class ReportCommand extends Command {
	ToyRobot robot = ToyRobot.getInstance();
	
	public ReportCommand()
	{
		super(REPORT);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// for debug purpose
		System.out.println(REPORT);
		
		robot.robotReport();
	}
}
