package Exam1;

public class MeterTest {
	
	public static void main (String[] args) {
		
		ParkingMeter pm = new ParkingMeter(15,60);
		pm.insertCoin(3);
		pm.passtime(20);
		
		System.out.println(pm.getTimeRemaining());
		System.out.println("Expected 25");
		System.out.println(pm.getTotal());
		System.out.println("Expected 0.75");
		
		pm.insertCoin(4);
		pm.passtime(90);
		
		System.out.println(pm.getTimeRemaining());
		System.out.println("Expected 0");
		System.out.println(pm.getTotal());
		System.out.println("Expected 1.75");

	}

}
