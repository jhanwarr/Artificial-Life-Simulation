
public abstract class Organism 
{
	private int energy;
	//Instance Variable – To store the energy of each organism object
	
	/**
	 * Constructor to initialize the instance variables
	 */
	public Organism()
	{
		energy = 0;
	}
	
	/**
	 * Incrementing the energy aspect under the update() method in population
	 */
	void update()
	{
		incrementEnergy();
	}
	
	/**
	 * Getter method for the energy of an organism
	 * @return energy value of the organism
	 */
	int getEnergy()
	{
		return energy;
	}
	
	/**
	 * Setter method for the energy of the organism to be initialized to zero
	 */
	void setEnergyToZero()
	{
		energy = 0;
	}
	
	/**
	 * Method to increment the value of energy by 1
	 */
	void incrementEnergy()
	{
		energy++;
	}
	
	/**
	 * Method to decrement the value of energy of the organism, if possible
	 * @throws EnergyBelowZeroException if the energy of the organism is being reduced when it already has no energy points left
	 */
	void decrementEnergy() throws EnergyBelowZeroException
	{
		if(energy == 0)
		{
			throw new EnergyBelowZeroException();
		}
		
		energy--;
	}
	
	//The Abstract Methods which helps for better specification of the types of organisms and thus, more encapsulation
	
	/**
	 * 
	 * @return the type of the given organism
	 */
	abstract String getType();
	
	/**
	 * 
	 * @return a newly created Organism subclass with the same type as that of the organism that created it
	 */
	abstract Organism reproduce();
	
	/**
	 * 
	 * @return the cooperation probability of the given type of organism
	 */
	abstract double getCooperationProbability();
	
	/**
	 * 
	 * @return whether or not the given Organism is willing to cooperate or not
	 */
	abstract boolean cooperates();	
}
