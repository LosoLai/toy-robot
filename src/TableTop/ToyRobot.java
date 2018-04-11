package TableTop;
import ErrorMessages.LocationBoundaryRelated;

/**
 * ToyRobot inheritance from TableItem
 */
public class ToyRobot extends TableItem {	
	public final static String NORTH = "NORTH";
	public final static String SOUTH = "SOUTH";
	public final static String EAST = "EAST";
	public final static String WEST = "WEST";
	
	private String facing;
	private static ToyRobot instance = null;
	private int instanceConter;
	
	//record next valid movement
	private int nextPosX;
	private int nextPosY;
	
	public static ToyRobot getInstance()
	{
		if(instance == null)
			instance = new ToyRobot();
		
		return instance;
	}
	
	public int getInstanceConter() {
		return instanceConter;
	}

	public void setInstanceConter() {
		this.instanceConter++;
	}
	
	
	private ToyRobot()
	{
		super(TableItem.ROBOT);
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}
	
	//facing string validation
	public static boolean checkFacing(String facing)
	{
		String upper = facing.toUpperCase();
		if(!upper.matches(NORTH) && 
		   !upper.matches(SOUTH) &&
		   !upper.matches(EAST)  &&
		   !upper.matches(WEST))
		{
			LocationBoundaryRelated.displayFacingInvalidMessage();
			return false;
		}
		
		return true;
	}
	
	//robot movement
	public boolean isAbleToMove()
	{
		//check one step from the direction
		//will be out of the position range
		int curPosX = this.getPosX();
		int curPosY = this.getPosY();
		String curFacing = this.getFacing();
		
		if(curFacing.matches(NORTH))
			curPosY++;
		if(curFacing.matches(SOUTH))
			curPosY--;
		if(curFacing.matches(EAST))
			curPosX++;
		if(curFacing.matches(WEST))
			curPosX--;
		
		//check new position
		if(!TableItem.checkPosX(curPosX))
			return false;
		if(!TableItem.checkPosY(curPosY))
			return false;
		
		//validate position
		nextPosX = curPosX;
		nextPosY = curPosY;
		return true;
	}
	
	public void robotMove()
	{
		this.setPosX(nextPosX);
		this.setPosY(nextPosY);
	}
}
