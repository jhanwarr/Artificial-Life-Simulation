import java.util.HashMap;
import java.util.Map;
//libraries required

public class ALifeSim //The client class
{
	/**
	 * The main method for creating a map of organisms and coordinates the call to other functions
	 * @param args Array containing Command Line Arguments
	 */
	public static void main(String[] args) 
	{
		try
		{
			int iterations = Integer.valueOf(args[2]);

			Map<String, Integer> counts = new HashMap<>();

			counts.put("Cooperator", Integer.valueOf(args[3]));
			counts.put("Defector", Integer.valueOf(args[4]));
			counts.put("PartialCooperator", Integer.valueOf(args[5]));
			//creating the population of the different type of organisms

			Population obj = new Population(counts);

			for(int i = 0; i<iterations; i++)
			{
				obj.update();
			}

			counts = obj.getPopulationCounts();
			
			//Printing the information after the specified number of ticks/updates for each organism in the petridish
			System.out.println("After "+iterations+" ticks: ");
			System.out.println("Cooperators = "+(counts.get("Cooperator") != null ? counts.get("Cooperator") : 0));
			System.out.println("Defectors   = "+(counts.get("Defector") != null ? counts.get("Defector") : 0));
			System.out.println("Partial     = "+(counts.get("PartialCooperator") != null ? counts.get("PartialCooperator") : 0));
			System.out.println();
			System.out.println("Mean Cooperation Probability = "+obj.calculateCooperationMean());
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Invalid number of inputs provided.");
		}
		catch(ClassCastException e)
		{
			System.err.println("Invalid input types provided.");
		}
		catch(Exception e)
		{
			System.err.println("Unkown error occured. Printing the error message - ");
			System.err.println(e.getMessage());
		}
		//Error Handling
	}
}
