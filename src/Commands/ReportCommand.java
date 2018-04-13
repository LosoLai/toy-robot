package Commands;
import TableTop_Model.ToyRobot;

public class ReportCommand extends Command {
	public final static String REPORT = "REPORT";
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
