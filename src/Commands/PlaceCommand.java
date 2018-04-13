package Commands;
import ErrorMessages_View.*;
import Simulator_Controller.Simulator;
import TableTop_Model.*;

/**
 * PlaceCommand class inheritance from Command
 * Responsibilities:
 * checking three parameters when instantiate
 * - posX
 * - posY
 * - facing
 */
public class PlaceCommand extends Command {
	public final static String PLACE = "PLACE";
	
	public final static int PARA_REQUIRED_SIZE = 4;
	public final static int PARA_POSX = 1;
	public final static int PARA_POSY = 2;
	public final static int PARA_FACEING = 3;
	public final static int PLACE_LIMIT = 1;
	
	private int posX;
	private int posY;
	private String facing;
	
	//add getters for JUnit testing
	public String getPara0_Type()
	{
		return getCommandType();
	}
	public int getPara1_posX()
	{
		return posX;
	}
	public int getPara2_posY()
	{
		return posY;
	}
	public String getPara3_Facing()
	{
		return facing;
	}

	public PlaceCommand(String[] inputs)
	{
		super(PLACE);
		
		//check parameters size
		if(inputs.length != PARA_REQUIRED_SIZE)
		{
			//show error message
			CommandRelated.displayCommandParaInvilad();
			this.setExecutableFlag(false);
		}
		else
		{
			try{
				posX = Integer.parseInt(inputs[PARA_POSX]);
				//checking position X boundary
				if(!TableItem.checkPosX(posX))
					super.setExecutableFlag(false);
			} catch(Exception e){
				CommandRelated.displayInputFormatInvalid(inputs[PARA_POSX]);
			}
			
			try{
				posY = Integer.parseInt(inputs[PARA_POSY]);
				//checking position Y boundary
				if(!TableItem.checkPosY(posY))
					super.setExecutableFlag(false);
			} catch(Exception e){
				CommandRelated.displayInputFormatInvalid(inputs[PARA_POSX]);
			}
			
			try{
				facing = inputs[PARA_FACEING];
				//checking facing
				if(!ToyRobot.checkFacing(facing))
					super.setExecutableFlag(false);
			} catch(ArrayIndexOutOfBoundsException e) {
				CommandRelated.displayCommandParaInvilad();
			} catch(NullPointerException e) {
				CommandRelated.displayCommandParaInvilad();
			}
		}
	}
	
	/**
	 * abstract method: execute()
	 * Function:
	 * checking isExecutable, if so instantiate ToyRobot instance
	 * set the counter to record the number of PlaceCommand is executed
	 * first time execution is setting the parameters into ToyRobot 
	 * - posX
	 * - posY
	 * - facing
	 */
	@Override
	public void execute() {
		if(!super.isExecutableFlag())
		{
			CommandRelated.diaplayCommandIgnore();
			return;
		}	
		
		ToyRobot robot = ToyRobot.getInstance();
		Simulator.getInstance().setPlaceCounter();
		
		if(Simulator.getInstance().getPlaceCounter() > PLACE_LIMIT)
			RobotRelated.displayHasRobotAlready();
		else
		{
			robot.setPosX(posX);
			robot.setPosY(posY);
			robot.setFacing(facing);
		}
		
	}
}
