package ErrorMessages_View;

public class RobotRelated {
	public static void displayRobotIsNullMessage()
	{
		System.out.println("ERROR: There is no toy robot on table now.");
		System.out.println("ERROR: Please use PLACE X,Y,F command to place the robot.");
	}
	
	public static void displayHasRobotAlready()
	{
		System.out.println("WARRING: Already has a toy robot on table now.");
	}
}
