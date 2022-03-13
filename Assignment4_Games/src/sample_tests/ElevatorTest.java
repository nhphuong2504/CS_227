package sample_tests;

import hw4.Elevator;
import hw4.Lurker;
import hw4.Platform;

public class ElevatorTest {
	
	public static void main(String[] args)
	  {
		Elevator e = new Elevator(50, 200, 10, 10);
		e.setBounds(190, 220);
		e.setVelocity(0, 3);
		
		Lurker l = new Lurker(5,5,2);
		l.setVelocity(2, 0);
		e.addChild(l);
		
//		System.out.println(l.getXReal() + ", " + (l.getXReal() + 5)); 	//52, 57
//		System.out.println(e.getXReal() + ", " + (e.getYReal()));	//50, 200
//		System.out.println();
////		
//		e.update();
//		
//		System.out.println("bounds " + l.getMin() + ", " + l.getMax());	//bounds 50 , 60
//		System.out.println(l.getXReal() + ", " + (l.getXReal() + 5) + ", " + l.getYReal()); // 54,59,198
//		System.out.println(e.getXReal() + ", " + (e.getYReal())); 	//50 , 203
//		System.out.println();
////		
//		e.update();
//		
//		System.out.println("bounds " + l.getMin() + ", " + l.getMax());	//bounds 50, 60
//		System.out.println(l.getXReal() + ", " + (l.getXReal() + 5) + ", " + l.getYReal());	//55, 60, 201
//		System.out.println("Velocity: " + l.getDeltaX());	//-2
		
		//----
		
	      // first try an example where the parent doesn't move
	      // left side at x = 50, width 10, right side at 60
//	      Elevator p = new Elevator(50, 200, 10, 10);
//	      p.setBounds(190, 220);
//////	      
//////	      // size 5 x 5, initial offset 2 units from left of platform
//	      Lurker e = new Lurker(5, 5, 2);
//	      e.setVelocity(0, 2);
//////////	      
//	      // this should automatically make p the parent of e
//	      // and the left and right sides of p the boundaries of e
//	      p.addChild(e);      
//	      System.out.println(e.getMin());  // 200
//	      System.out.println(e.getMax());  // 210
//	      System.out.println();
//////	      
//	      // x position should be the parent position + 2 = 52
//	      // y position should be parent y - lurker height = 195
////	      System.out.println(e.getXReal());  // expected 52
////	      System.out.println(p.getXReal());
//	      System.out.println(e.getYReal());  // expected 195
//	      System.out.println();
////////////	      
//////	      // platform doesn't move here, but lurker does
//	      p.update();
//	      System.out.println(p.getYReal()); // 200
//	      System.out.println(e.getYReal() + ", " + (e.getYReal() + 5));  // expected 197, 202
//	      System.out.println(e.getDeltaY()); // expected 2.0
//	      System.out.println();
//	      p.update();
//	      System.out.println(e.getXReal() + ", " + (e.getXReal() + 5)); // expected 55, 60
//	      System.out.println(e.getDeltaX()); // expected -2.0
//	      System.out.println();
//	      System.out.println();
		
//			e = new Elevator(10, 200, 10, 10);
//			e.setVelocity(0, 4);
//			
//			l = new Lurker(5,5,3);
//			e.addChild(l); 
//			
//			e.update();
//			e.update();
//			
//			System.out.println(l.getXReal());
//	
//			System.out.println(l.getFrameCount());
	  }

}
