package CostomizedExceptions;

public class CommandNotExistException extends Exception{
	public CommandNotExistException(String errMsg) {
		super(errMsg);
	}
}