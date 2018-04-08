/**
 * ToyRobot inheritance from TableItem
 */
public class ToyRobot extends TableItem {
	public final static String NORTH = "NORTH";
	public final static String SOUTH = "SOUTH";
	public final static String EAST = "EAST";
	public final static String WEST = "WEST";
	
	private String facing;
	
	public ToyRobot(int posX, int posY, String facing)
	{
		super(TableItem.ROBOT, posX, posY);
		this.facing = facing;
	}
}
