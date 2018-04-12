package Commands;
import TableTop_Model.ToyRobot;
/**
 * Command is a Abstract class 
 * provide the constructor for initial variable (type)
 */
public abstract class Command {
	public final static int PLACE = 1;
	public final static int MOVE = 2;
	public final static int LEFT = 3;
	public final static int RIGHT = 4;
	public final static int REPORT = 5;
	
	private int commandType;
	private boolean executableFlag;

	public Command(int type)
	{
		setCommandType(type);
		setExecutableFlag(true);
	}

	public int getCommandType() {
		return commandType;
	}

	public void setCommandType(int commandType) {
		this.commandType = commandType;
	}
	
	public boolean isExecutableFlag() {
		return executableFlag;
	}

	public void setExecutableFlag(boolean executableFlag) {
		this.executableFlag = executableFlag;
	}
	
	abstract public void execute();
}
