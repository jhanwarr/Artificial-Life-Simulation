
public class Cooperator extends Organism
{
	private static final double probability = 1;
	//Instance Variables – the probability of the Cooperator Organism type to cooperate

	/**
	 * 
	 * @return the type of the given organism
	 */
	String getType()
	{
		return "Cooperator";
	}

	/**
	 * 
	 * @return a newly created Organism subclass with the same type as that of the organism that created it
	 */
	Organism reproduce()
	{
		if(getEnergy() >= 10)
		{
			setEnergyToZero();
			return new Cooperator();
		}

		return null;
	}

	/**
	 * 
	 * @return the cooperation probability of the given type of organism
	 */
	double getCooperationProbability()
	{
		return probability;
	}

	/**
	 * 
	 * @return whether or not the given Organism is willing to cooperate or not
	 */
	boolean cooperates()
	{
		return true;
	}
}
