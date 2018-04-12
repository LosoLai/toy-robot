package ErrorMessages;

public class CommandRelated {
	public static void diaplayCommandIgnore()
	{
		System.out.println("Sorry, Command ignore.");
	}
	public static void displayInputFormatInvalid(String str)
	{
		if(str.length() >= 32)
			System.out.println("Input overflow, please enter valid range!");
		else
			System.out.println("Input Invalid, please make sure only enter a number");
	}
}
