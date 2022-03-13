package Exam1;

public class ParkingMeter {
	
	private double total;
	private int minPerQuater;
	private int maxTime;
	private int time;

	public ParkingMeter(int minutesPerQuater, int maximumTime) {
		
		minPerQuater = minutesPerQuater;
		maxTime = maximumTime;
		time = 0;
		total = 0.0;
	}
	public void insertCoin( int howMany) {
		
		time = time + (howMany * minPerQuater);
		time = Math.min(time, maxTime);
		total = total + (howMany / 4.0);
	}
	public int getTimeRemaining() {

		return time;
	}
	public void passtime(int minutes) {
		
		time = time - minutes;
		time = Math.max(time, 0);
	}
	
	public double getTotal() {

		return total;
	}

}
