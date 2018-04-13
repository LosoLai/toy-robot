package Commands;

/**
 * Command is an Abstract class that providing the constructor
 * for initial variable (commandType & executableFlag)
 * and defined a abstract public void execute() 
 * that required concrete implementation in sub-classes
 */
public abstract class Command {	
	private String commandType;
	private boolean executableFlag;

	public Command(String type)
	{
		setCommandType(type);
		setExecutableFlag(true);
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
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
