package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel5
{
	private int population;
	private int lastYear;
	private int yearBefore;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel5()
  {
   population = 1;
   lastYear = 1;
   yearBefore = 0;
    
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  
    population  = lastYear + yearBefore;
    yearBefore = lastYear;
    lastYear = population;
    
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  population = 1;
	  lastYear = 1;
	  yearBefore = 0;
    
  }
}
