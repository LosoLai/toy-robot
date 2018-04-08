/**
 * TableItem is a Abstract class 
 * provide the constructor for initial variable (type)
 */
public abstract class TableItem {
	public final static int EMPTY = 0;
	public final static int ROBOT = 1;
	
	private int itemType;
	private int posX;
	private int posY;
	
	//constructors
	public TableItem(int itemType)
	{
		setItemType(itemType);
	}
	public TableItem(int itemType, int posX, int posY)
	{
		setItemType(itemType);
		setPosX(posX);
		setPosY(posY);
	}
	
	// item getter and setter
	protected void setItemType(int itemType)
	{
		this.itemType = itemType;
	}
	public int getItemType()
	{
		return itemType;
	}
	
	//position getters and setters
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
}
