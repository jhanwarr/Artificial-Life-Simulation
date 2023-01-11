
public class PartialCooperator extends Organism
{
	private static final double probability = 0.5;
	private boolean lastTime = false;
	//Instance Variables – the probability of the Partial Cooperator Organism type to cooperate

	/**
	 * @return the type of the given organism
	 */
	String getType()
	{
		return "PartialCooperator";
	}

	/**
	 * @return a newly created Organism subclass with the same type as that of the organism that created it
	 */
	Organism reproduce()
	{
		if(getEnergy() >= 10)
		{
			setEnergyToZero();
			return new PartialCooperator();
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
		if(lastTime)
		{
			lastTime = false;
			return lastTime;
		}

		else
		{
			lastTime = true;
			return lastTime;
		}
	}
}
