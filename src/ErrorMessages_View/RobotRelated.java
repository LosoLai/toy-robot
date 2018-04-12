package ErrorMessages_View;

public class RobotRelated {
	public static void displayRobotIsNullMessage()
	{
		System.out.println("There is no toy robot on table now.");
		System.out.println("Please use PLACE X,Y,F command for place the robot.");
	}
	
	public static void displayHasRobotAlready()
	{
		System.out.println("Already has a toy robot on table now.");
	}
}
