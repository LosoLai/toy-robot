package ErrorMessages;

public class LocationBoundaryRelated {
	public final static int UNIT_SIZE = 5;
	public final static int STARTINX = 0;
	public final static int ENDINX = 4;
	
	public static void displayPosXOutOfRange()
	{
		System.out.println("Position X is out of range.");
		System.out.println("Please remain in the range :" + STARTINX + "-" + ENDINX);
	}
	public static void displayPosYOutOfRange()
	{
		System.out.println("Position Y is out of range.");
		System.out.println("Please remain in the range :" + STARTINX + "-" + ENDINX);
	}
}
