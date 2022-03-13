package Exam1;

public class Copies {
//	public static int findCopyCost(int numCopies) {
//		int cost = 0;
//		if (numCopies <= 10) {
//			cost = numCopies * 15;
//		}
//		else if (numCopies < 100) {
//			cost = 150 + ((numCopies - 10) *12);
//		}
//		else {
//			cost = 150 + 90*12 + (numCopies - 100)*12;
//		}
//		
//		return cost;
//	}

	public static void main (String[] args) {
		int numCopies = 150;
		double cost = 0;
		if (numCopies <= 10) {
			cost = numCopies * 15;
		}
		else if (numCopies < 110) {
			cost = 150 + ((numCopies - 10) *12);
		}
		else {
			cost = 150 + 100*12 + (numCopies - 110)*8;
		}
		
		System.out.println(cost / 100.0);
	}
}