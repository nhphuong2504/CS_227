package lab1;
//import java.awt.Rectangle;
import java.util.Random;
import java.util.Scanner;
public class Greeter {

//	public class OrderStrings {
	public static void main (String [] args) {
//		Random rand = new Random();
//		System.out.println(rand.nextInt(2));
//		Scanner scnr = new Scanner(System.in);
//		Interger i = new Interger();
//		
//		System.out.println("Moi ban nhap so: " );
//		int x = scnr.nextInt();
//		boolean isOdd = (x % 2 != 0);
//		System.out.println(isOdd);
		
//		int eggCount = scnr.nextInt();
//		int fullCarton = eggCount % 12;
//		System.out.println(fullCarton);
		
//		String s1 = "Hel";
//		String i = "20";
//		String str = "123"; 
//		char lastChar = str.charAt(str.length() - 1);
//		System.out.println(lastChar);
//		String s2 = "Hello Vietnam ";
//		boolean areTheSameString = s1.equals(s2);
//		System.out.print(areTheSameString);
//		boolean hasAtLeast4 = (s1.length() >= 4);
//		System.out.println(hasAtLeast4);
//		Interger s = Interger.parseInt(i);
////		System.out.println(s);
//		double d = 4.523;
//		int c = (int) d;
//		System.out.println(c);
//		double a = 42.32;
//		int b = (int) a;
//		double d = a + (double) b / 100;
//		System.out.println(b);
		
//		Random rd = new Random();

//		System.out.println(a);
//		Rectangle rect = new Rectangle(10, 20, 30, 40);
//		Rectangle rect2 = new Rectangle(2, 4, 6, 8);
//		int b = a;
//		Rectangle rect3 = rect;
////		rect3.setWidth(99);
//		rect3.setWidth(99);
////		rect2.setX(137);
//		b = b + 5;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(rect.getWidth());
//		String firstName = "Phuong";
//		String lastName = "Nguyen";
//		String f = firstName.toLowerCase();
//		String l = lastName.toLowerCase();
//		Random rand = new Random();
//		String a = f.substring(0,1);
//		System.out.println(a + l + rand.nextInt(50));
//		System.out.println(f);
//		Greeter x = new Greeter();
//		x.foo(2, 1);
//		System.out.println(x);
//	}
		
//		
//			System.out.println("Nhap x: ");
//			Scanner scnr = new Scanner(System.in);
//			int x = scnr.nextInt();
//			
//			System.out.println("Nhap y: ");
//			
//			scnr = new Scanner(System.in);
//			int y = scnr.nextInt();
//			
//			boolean result = false;
//			result = ((x > y) && (y != 0) || x == 0);
////			result = x > y; 
////			result = y != 0;
////			result = ( x == 0);
//			System.out.println(result);
		
//		Rectangle a;
//		int a = 42;
//		Rectangle rect = new Rectangle(10, 20, 30, 40); // (x, y, width, height)
//		Rectangle rect2 = new Rectangle(2, 4, 6, 8);
//		int b = a;
//		Rectangle rect3 = rect;
//		
//		rect3.setWidth(99);
//		
//		rect2.setX(137);
//		
//		b = b + 5;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(rect.getWidth());
		
//		int x = 42;
//		String y = "lunchtime";
//		
//		boolean results;
//		
//		results = (x >= 25);
//		results = (x >= 25 && x <= 50);
//		results = y.length() == 10 || y.length() == 12;
//		results = x == (y.length() * 3); 
//		results = y.length() % 3 != 0;
//		results = (x < 0 || (x % 2 == 0 && x % 3 != 0));
//		results = y.equals("dinner");
//		System.out.println(results);
		
		Scanner scnr = new Scanner("foo 3.14 42");
	    
	    System.out.println(scnr.hasNext());
	    System.out.println(scnr.hasNextInt());
	    System.out.println(scnr.hasNextDouble());
	    String temp = scnr.next();
	    System.out.println("Read first item: " + temp);
	    System.out.println();
	   
	    System.out.println(scnr.hasNext());
	    System.out.println(scnr.hasNextInt());
	    System.out.println(scnr.hasNextDouble());
	    double d = scnr.nextDouble();
	    System.out.println("Read second item: " + d);
	    System.out.println();
//	    
	    System.out.println(scnr.hasNext());
	    System.out.println(scnr.hasNextInt());
	    System.out.println(scnr.hasNextDouble());
	    int i = scnr.nextInt();
	    System.out.println("Read third item: " + i);
	    System.out.println();
//	    
	    System.out.println(scnr.hasNext());
	    System.out.println(scnr.hasNextInt());
	    System.out.println(scnr.hasNextDouble());
	    System.out.println("(Input stream now empty.)");
		    
		
	}
		
	
}
	
	   
