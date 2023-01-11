
public class Defector extends Organism
{
	private static final double probability = 0;
	//Instance Variables – the probability of the Defector Organism type to cooperate

	/**
	 * @return the type of the given organism
	 */
	String getType()
	{
		return "Defector";
	}

	/**
	 * @return a newly created Organism subclass with the same type as that of the organism that created it
	 */
	Organism reproduce()
	{
		if(getEnergy() >= 10)
		{
			setEnergyToZero();
			return new Defector();
		}

		return null;
	}

	/**
	 * @return the cooperation probability of the given type of organism
	 */
	double getCooperationProbability()
	{
		return probability;
	}

	/**
	 * @return whether or not the given Organism is willing to cooperate or not
	 */
	boolean cooperates()
	{
		return false;
	}
}
