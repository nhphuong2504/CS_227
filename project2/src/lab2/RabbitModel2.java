package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel2
{
	private int population;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel2()
  {
   population = 0;
   reset();
    
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
//    if (population % 4 == 0) 
//    {
//    	population = 0;
//    }
//    else
//    {
//    	population = population + 1;
//    }
//	  year = population + 1;
	  population = population + 1;
	  population = population % 5;
	  
  }
   
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    population = 0;
  }
}
