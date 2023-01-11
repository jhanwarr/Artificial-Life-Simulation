
public class EnergyBelowZeroException extends Exception
{
	//Creating a custom exception for this program to inform us when energy of an organism drops below 0
	
	public EnergyBelowZeroException()
	{
		super("Energy was being decremented despite its level being zero"); //The default message
	}
	
	public EnergyBelowZeroException(String message)
	{
		super(message); //User provided message
	}
}
