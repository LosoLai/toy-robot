import java.util.*;
/**
 * Application create a Simulator object
 * for monitoring toy robot status
 */
public class Appliaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		Simulator simulator = new Simulator();
		
		//display instructions
		showInstructions();
		
		boolean bExit = false;
		while(!bExit)
		{			
			String str = reader.nextLine();
			//need to validate the input string first 
			//- but implement it later
			
			String[] inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
			boolean bResult = simulator.excuteCommand(inputs);
		}
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
	}

}
