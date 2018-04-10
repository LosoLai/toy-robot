package Commands;
import ErrorMessages.RobotRelated;
import TableTop.ToyRobot;

public class PlaceCommand extends Command {
	public final static int PARA_POSX = 1;
	public final static int PARA_POSY = 2;
	public final static int PARA_FACEING = 3;
	public final static int PLACE_LIMIT = 1;
	
	private int posX;
	private int posY;
	private String facing;

	public PlaceCommand(String[] inputs)
	{
		super(PLACE);
		
		if(inputs.length > 1 && inputs.length <= 4)
		{
			//also need to check the string validation here
			posX = Integer.parseInt(inputs[PARA_POSX]);
			posY = Integer.parseInt(inputs[PARA_POSY]);
			facing = inputs[PARA_FACEING];
		}
		else 
		{
			//should new expection for it
			//instead of returning false
		}
	}
	
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		System.out.println(PLACE);
		
		ToyRobot robot = ToyRobot.getInstance();
		robot.setInstanceConter();
		
		if(robot.getInstanceConter() > PLACE_LIMIT)
			RobotRelated.displayHasRobotAlready();
		else
		{
			robot.setPosX(posX);
			robot.setPosY(posY);
			robot.setFacing(facing);
		}
		
	}
}
