package Exam1;
import java.util.Scanner;
public class Pizza {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many? ");
		int numPizza = sc.nextInt();
		
		System.out.print("ISU student (yes/no)?");
		String isu = sc.next();
		
		double price = 0;
		
		if (isu.equals("yes")) {
			if (numPizza < 5) {
				price = 8.00 * numPizza;
			}
			else {
				int x = numPizza % 5;
				int y = numPizza / 5;
				price = y*32 + x*8;
			}
		}
		else {
			if (numPizza < 5) {
				price = 8.00 * numPizza + 0.5*numPizza;
			}
			else {
				int x = numPizza % 5;
				int y = numPizza / 5;
				price = y*32 + x*8 + 0.5*numPizza;
			}
		}
		System.out.println("Price " + price);
	}
}
