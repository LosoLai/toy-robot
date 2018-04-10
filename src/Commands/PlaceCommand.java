package Commands;

public class PlaceCommand extends Command {
	public final static int PARA_POSX = 1;
	public final static int PARA_POSY = 2;
	public final static int PARA_FACEING = 3;
	
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
		
	}

}
