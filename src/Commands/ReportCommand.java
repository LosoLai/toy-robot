package Commands;
import TableTop.ToyRobot;

public class ReportCommand extends Command {
	
	public ReportCommand()
	{
		super(REPORT);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(REPORT);
	}

}
