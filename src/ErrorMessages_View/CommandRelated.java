package ErrorMessages_View;

public class CommandRelated {
	public static void diaplayCommandIgnore()
	{
		System.out.println("WARRANG: Sorry, Command ignore.");
	}
	public static void displayInputFormatInvalid(String str)
	{
		if(str.length() >= 32)
			System.out.println("ERROR: Input overflow, please enter valid range!");
		else
			System.out.println("ERROR: Input Invalid, please make sure only enter a number");
	}
	public static void displayCommandParaInvilad()
	{
		System.out.println("ERROR: Place command parameters doen't fit.");
		System.out.println("ERROR: Please enter 3 parameters (ex. PLACE 0,0,NORTH)");
	}
}
