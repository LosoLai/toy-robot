package ErrorMessages_View;

public class LocationBoundaryRelated {
	public final static int UNIT_SIZE = 5;
	public final static int STARTINX = 0;
	public final static int ENDINX = 4;
	
	public static void displayPosXOutOfRange()
	{
		System.out.println("ERROR: Position X is out of range.");
		System.out.println("ERROR: Please remain in the range :" + STARTINX + "-" + ENDINX);
	}
	
	public static void displayPosYOutOfRange()
	{
		System.out.println("ERROR: Position Y is out of range.");
		System.out.println("ERROR: Please remain in the range :" + STARTINX + "-" + ENDINX);
	}
	
	public static void displayPosXOutOfTableRange()
	{
		System.out.println("WARRING: Position X is out of table range.");
		System.out.println("WARRING: Robot remains in the same position.");
	}
	
	public static void displayPosYOutOfTableRange()
	{
		System.out.println("WARRING: Position X is out of table range.");
		System.out.println("WARRING: Robot remains in the same position.");
	}
	
	public static void displayFacingInvalidMessage()
	{
		System.out.println("WARRING: Robot face direction is invalid.");
	}
}
