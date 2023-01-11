import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//The libraries required

public class Population 
{
	private ArrayList<Organism> population;
	//Instance Variable – Array list to store the data
	
	/**
	 * The constructor
	 * @param counts The map containing keys for the given population type.
	 */
	Population(Map<String, Integer> counts)
	{
		population = new ArrayList<>();
		
		for(String s: counts.keySet())
		{
			if(s.equals("Cooperator"))
			{
				for(int i = 1; i<=counts.get(s); i++)
				{
					population.add(new Cooperator());
				}
			}
			
			else if(s.equals("PartialCooperator"))
			{
				for(int i = 1; i<=counts.get(s); i++)
				{
					population.add(new PartialCooperator());
				}
			}
			
			else if(s.equals("Defector"))
			{
				for(int i = 1; i<=counts.get(s); i++)
				{
					population.add(new Defector());
				}
			}
			
			else
				throw new IllegalArgumentException("The inputted Organism Type ("+s+") doesn't exist.");
		}
	}
	
	/**
	 * The update method for increasing the energy of the organism by one, working its cooperation with others, and checking for reproduction.
	 */
	public void update()
	{
		for(int i = 0; i<population.size(); i++)
		{
			Organism organism = population.get(i);
			organism.update();
			//UPDATE

			if(organism.cooperates())
			{
				try
				{
					organism.decrementEnergy();

					Set<Integer> indexes = new HashSet<Integer>();
					indexes.add(i);
					
					while(indexes.size() < 9)
					{
						indexes.add(random());
					}
					
					indexes.remove(i);

					for(int index: indexes)
					{
						population.get(index).incrementEnergy();
					}
				}

				catch(EnergyBelowZeroException e)
				{
					System.err.println(e.getMessage()+ " for the organism at "+i);
				}
			}
			//COOPERATE
			
			Organism newBorn = organism.reproduce();
			
			if(!(newBorn == null))
			{
				population.set(random(), newBorn);
			}
			//REPRODUCE
		}
	}

	/**
	 * Method to generate a random number between 0 and population's size
	 * @return a random number between 0 and population's size
	 */
	private int random()
	{
		return (int)(Math.random() * population.size());
	}
	
	/**
	 * Function to calculate the total sum  of all organism's cooperation divided by the population size. 
	 * @return the mean cooperation value for the given population
	 */
	public double calculateCooperationMean()
	{
		double mean = 0;
		
		for(Organism organism: population)
		{
			mean += organism.getCooperationProbability();
		}
		//The sum of the cooperation means of all the organisms
		
		mean /= population.size();
		
		return mean;
	}
	
	/**
	 * Generating a map that has the type of organisms mapped to their population in the petridish
	 * @return a hashmap mapped with species type to their respective population
	 */
	public Map<String, Integer> getPopulationCounts()
	{
		Map<String, Integer> counts = new HashMap<>();
		
		for(Organism organism: population)
		{
			String type = organism.getType();
			
			if(counts.containsKey(type))
			{
				counts.put(type, counts.get(type)+1);
			}
			
			else
			{
				counts.put(type, 1);
			}
		}
		
		return counts;
	}
}
