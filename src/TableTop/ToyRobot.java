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
	
	public final static int DIRECTIONS = 4;
	private final int NORTH_INX = 0;
	private final int EAST_INX  = 1;
	private final int SOUTH_INX = 2;
	private final int WEST_INX  = 3;
	private String[] directions;
	
	private static ToyRobot instance = null;
	private int instanceConter;
	
	//record next valid movement
	private int nextPosX;
	private int nextPosY;
	
	//record direction
	private String facing;
	private int curDirection;
	
	public static ToyRobot getInstance()
	{
		if(instance == null)
			instance = new ToyRobot();
		
		return instance;
	}
	
	private ToyRobot()
	{
		super(TableItem.ROBOT);
		
		//inital directions
		directions = new String[DIRECTIONS];
		directions[NORTH_INX] = NORTH;
		directions[EAST_INX] = EAST;
		directions[SOUTH_INX] = SOUTH;
		directions[WEST_INX] = WEST;
	}
	
	public int getInstanceConter() {
		return instanceConter;
	}

	public void setInstanceConter() {
		this.instanceConter++;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
		
		//record current direction
		String upperStr = this.facing.toUpperCase();
		if(upperStr.matches(NORTH))
			curDirection = NORTH_INX;
		else if(upperStr.matches(EAST))
			curDirection = EAST_INX;
		else if(upperStr.matches(SOUTH))
			curDirection = SOUTH_INX;
		else
			curDirection = WEST_INX;
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
	
	public void robotTurnLeft()
	{
		curDirection--;
		
		if(curDirection < 0)
			curDirection = directions.length - 1;
		
		this.facing = directions[curDirection];
	}
	
	public void robotTurnRight()
	{
		curDirection++;
		
		if(curDirection >= directions.length)
			curDirection = 0;
		
		this.facing = directions[curDirection];
	}
}
