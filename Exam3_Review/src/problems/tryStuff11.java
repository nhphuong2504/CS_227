package problems;

import java.util.Scanner;

public class tryStuff11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tryStuff("10 20 23dwr 30 foo bar");

	}
	
	public static void tryStuff(String text) {
		
		int total = 0;
		int i = 0;
		Scanner sc = new Scanner(text);
		
		while (sc.hasNext()) {
			
			try {
				String s = sc.next();
				i = Integer.parseInt(s);
				total += i;
			}
			catch (NumberFormatException nfe) {
				total -= i;
			}
			System.out.println(total);
		}
	}

}
