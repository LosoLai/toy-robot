package Commands;
import TableTop_Model.ToyRobot;

public class ReportCommand extends Command {
	ToyRobot robot = ToyRobot.getInstance();
	
	public ReportCommand()
	{
		super(REPORT);
	}

	@Override
	public void execute() {	
		robot.robotReport();
	}
}
