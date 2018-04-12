
import java.util.*;
import CostomizedExceptions.CommandNotExistException;
import Simulator_Controller.Simulator;
/**
 * Application create a Simulator object
 * for monitoring toy robot status
 */
public class ToyRobotApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		Simulator simulator = Simulator.getInstance();
		
		//display instructions
		showInstructions();
		
		boolean bExit = false;
		try{
			while(!bExit)
			{			
				String str = reader.nextLine();
				//need to validate the input string first 
				//- but implement it later
				
				String[] inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
				boolean bResult = simulator.excuteInput(inputs);
				if(!bResult)
					bExit = true;
			}
		} catch(CommandNotExistException e) {
			//if the command type doen't match
			//exit system
			System.err.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("Unexpected exception occur.");
			System.err.println(e.getMessage());
		}
		
		//exit system
		showExitMemssage();
	}
	
	public static void showInstructions()
	{
		System.out.println("========Instructions========");
		System.out.println("PLACE X,Y,F");
		System.out.println("MOVE");
		System.out.println("LEFT");
		System.out.println("RIGHT");
		System.out.println("REPORT");
		System.out.println("EXIT");
		System.out.println("Please enter your command : ");
		System.out.println("============================");
	}
	
	public static void showExitMemssage()
	{
		System.out.println("========Exit SYSTEM========");
	}
}
