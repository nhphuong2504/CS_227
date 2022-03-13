package hw1;

/**
 * Models ridership and location of a city bus.
 * @author Phuong Hoang Nguyen
 */
public class CyrideBus {
	
	/**
	 *  a "bus garage", designated as stop number -1.
	 */
	public static final int BUS_GARAGE = -1;
	
	/**
	 * The maximum capacity of the bus
	 */
	private int maxCapacity;
	
	/**
	 * The number of stops of the bus.
	 */
	private int numStop;
	
	/**
	 * The number of current stop of the bus.
	 */
	private int currentStop;
	
	/**
	 * The number of current capacity of the bus.
	 */
	private int currentCapacity;
	
	/**
	 * The number of passengers on the bus.
	 */
	private int numPassenger;
	
	/**
	 * The number of total passengers on the bus from the beginning.
	 */
	private int totalRider;
	
	/**
	 * Status of the bus
	 */
	private boolean inService;
	
	/**
	 * Constructs a new bus with the given maximum capacity that will travel among the given number of stops
	 * @param givenMaxCapacity
	 * @param givenNumStops
	 */
	public CyrideBus(int givenMaxCapacity, int givenNumStops)
	{
		maxCapacity = givenMaxCapacity;
		numStop = givenNumStops;
		
		currentStop = BUS_GARAGE;
		currentCapacity = maxCapacity;
		
		numPassenger = 0;
		totalRider = 0;
		
		inService = true;
	}
	
	/**
	 * The current capacity of the bus
	 * @return the current capacity of the bus
	 */
	public int getCurrentCapacity()
	{
		return currentCapacity;
	}
	
	/**
	 * The current stop number.
	 * @return Returns the current stop number.
	 */
	public int getCurrentStop()
	{
		return currentStop;
	}
	
	/**
	 * The current number of passengers on the bus.
	 * @return the current number of passengers on the bus.
	 */
	public int getNumPassengers()
	{
		return numPassenger;
	}
	
	/**
	 * the total number of passengers who have gotten on this bus since it was constructed.
	 * @return the total number of passengers who have gotten on this bus since it was constructed.
	 * 
	 */
	public int getTotalRiders()
	{
		return totalRider;
	}
	
	/**
	 * Determines whether bus is in service or not.
	 * @return true if this bus is in service, false if not.
	 */
	public boolean isInService()
	{
		return inService; 
	}
	
	/**
	 * Simulates the bus travelling to its next stop with the number of people on and off.
	 * @param peopleOff
	 * @param peopleOn
	 */
	public void nextStop(int peopleOff, int peopleOn)
	{
		
		/**
		 * The number of people really get on the bus after every stop.
		 */
		int peopleOnReally;
		
		/**
		 * The number of current stop + 1 when the bus come to next stop. 
		 * When the bus to the end station. Its back to the first stop as a circle.
		 */
		currentStop = currentStop + 1;
		currentStop = currentStop % numStop;
		
		/**
		 * The bus will not take on any passengers until placed back in service. 
		 * It means currentCapacity = 0
		 */
		peopleOn = Math.min(peopleOn, currentCapacity);
		
		/**
		 * Subtract the number of Passenger who get off. 
		 * Current Passenger can not lower than 0.
		 */
		numPassenger = numPassenger - peopleOff;
		numPassenger = Math.max(numPassenger, 0);
		
		/**
		 * Variable to represent true number of passengers really get on the bus.
		 */
		peopleOnReally = Math.min(maxCapacity - numPassenger, peopleOn);
		
		/**
		 * Add the number of passengers who get on.
		 * Current passenger can not higher than bus max capacity.
		 */
		numPassenger = numPassenger + peopleOn;
		numPassenger = Math.min(maxCapacity, numPassenger);
		
		/**
		 * calculate the total number of passengers who have gotten on this bus from the beginning.
		 */
		totalRider = totalRider + peopleOnReally;
	}
	
	/**
	 * Places this bus in service.
	 */
	public void placeInService()
	{
		currentCapacity = maxCapacity;
		inService = true;
	}
	
	/**
	 * Takes this bus out of service.
	 */
	public void removeFromService()
	{
		currentCapacity = 0;
		numPassenger = 0;
		currentStop = BUS_GARAGE;
		inService = false;
	}
	
}
