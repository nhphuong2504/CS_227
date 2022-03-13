package sample_tests;
import hw4.BasicElement;
import hw4.Lurker;
import hw4.Missile;
import hw4.Platform;

public class MissileTest
{
  public static void main(String[] args)
  {
    Missile p = new Missile(0, 0, 0, 0);
    p.setVelocity(2, 3);
    p.update();
//    System.out.println(p.getXReal());
    System.out.println(p.getYReal()); // expected 3
    System.out.println(p.getDeltaY());// expected 3
    p.update();
//    System.out.println(p.getXReal());
    System.out.println(p.getYReal()); // expected 6
    System.out.println(p.getDeltaY());// expected 3
    p.setGravity(5);
    p.update();
    System.out.println(p.getYReal());  // 6 + 3 = 9
    System.out.println(p.getDeltaY()); // 3 + 5 = 8
    p.update();
    System.out.println(p.getYReal());  // 9 + 8 = 17
    System.out.println(p.getDeltaY()); // 8 + 5 = 13
    p.update();
    System.out.println(p.getYReal());  // 17 + 13 = 30
    System.out.println(p.getDeltaY()); // 13 + 5 = 18
    p.setBallistic(true);
    System.out.println(p.isBallistic());
//    BasicElement platform = new BasicElement(0,300,10,10);
//    Missile p = new Missile(0, 300, 1, 1);
//    System.out.println(p.collides(platform));  //true
//    p.setVelocity(1, -3);
//    p.setGravity(1);
//    p.update();
//    System.out.println();
//   
//
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (1,297)
//    System.out.println(p.getDeltaY());  // expected -2
//    System.out.println(p.collides(platform));  //false
//    p.setBallistic(true);
//    p.update();
//    System.out.println();
////
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (2,295)
//    System.out.println(p.getDeltaY());  // expected -1
//    p.update();
//    System.out.println();
//// 
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (3,294)
//    System.out.println(p.getDeltaY());  // expected 0
//    p.update();
//    System.out.println();
////   
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (4,294)
//    System.out.println(p.getDeltaY());  // expected 1
//    p.update();
//    System.out.println();
//   
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (5,295)
//    System.out.println(p.getDeltaY());  // expected 2
//    p.update();
//  
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (6,297)
//    System.out.println(p.getDeltaY());  // expected 3
//    p.update();
//    System.out.println();
//    
//    System.out.println("(" + p.getXReal() + ", " + p.getYReal() + ")"); // (7,300)
//    System.out.println(p.getDeltaY());  // expected 4
//    p.update();
//    System.out.println();
//    
////    System.out.println(p.collides(platform));        // TRUE 
//    System.out.println(p.collides(platform));
    
  }
}
