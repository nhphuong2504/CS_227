package sample_tests;
import hw4.Charm;
import hw4.Elevator;
import hw4.Platform;

public class PlatformWithCharmTest
{
  public static void main(String[] args)
  {
//      // left side at x = 50, width 10, right side at 60
//      Elevator p = new Elevator(50, 200, 5 , 5);
//      p.setBounds(190, 219);
//      p.setVelocity(0, 5);
////      
////      // size 5 x 5, offset 2 units from left of platform, 15 above
//      Charm c = new Charm(5, 5, 2, 15);
////      
////      // this should automatically make p the parent of c
//      p.addChild(c);
////      
////      // x position should be the parent position + 2 = 52
////      // y position should be parent y - charm height - hover = 180
////      System.out.println(c.getXReal());  // expected 52
//      System.out.println(c.getYReal());  // expected 180
////      System.out.println(p.getXReal());
//      System.out.println();
//      p.update();
////      System.out.println(p.getXReal());	//50
//      System.out.println(p.getYReal());	//205
////      System.out.println(c.getXReal());  // expected 52
//      System.out.println(c.getYReal());  // expected 185
////      System.out.println(p.getXReal());
//      System.out.println();
//      
//      p.update();
////      System.out.println(p.getXReal());	//50
//      System.out.println(p.getYReal());	//210
////      System.out.println(c.getXReal());  // expected 50
//      System.out.println(c.getYReal());  // expected 190
//      p.update();
//      System.out.println(p.getYReal());	//215
//      System.out.println(c.getYReal());  // expected 195
//      System.out.println(p.getDeltaY());
//////
////      // calling update on p should update children too
//      System.out.println(c.getFrameCount()); // expected 2
	  
      Platform p = new Platform(50, 200, 10, 10);
      p.setBounds(40, 70);
      p.setVelocity(6, 0);
      
      // size 5 x 5, offset 2 units from left of platform, 15 above
      Charm c = new Charm(5, 5, 2, 15);
      
      // this should automatically make p the parent of c
      p.addChild(c);
      
      // x position should be the parent position + 2 = 52
      // y position should be parent y - charm height - hover = 180
      System.out.println(c.getXReal());  // expected 52
      System.out.println(c.getYReal());  // expected 180
      p.update();
      System.out.println(c.getXReal());  // expected 58
      System.out.println(c.getYReal());  // expected 180
      p.update();
      System.out.println(c.getXReal());  // expected 62
      System.out.println(c.getYReal());  // expected 180

      // calling update on p should update children too
      System.out.println(c.getFrameCount()); // expected 2
      
      
    
  }
}
