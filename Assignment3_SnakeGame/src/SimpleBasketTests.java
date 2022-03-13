import java.io.FileNotFoundException;
import java.util.ArrayList;

import api.Direction;
import api.GridUtil;
import hw3.Snake;
import hw3.SnakeBasket;
import hw3.SnakeUtil;

public class SimpleBasketTests
{
  public static void main(String[] args) throws FileNotFoundException
  {
    String test0[] = {
      "#  E  #",
      "#  .  #", 
      "#  .  #",
      "#  .  #",
      "#  #  #"  
    };
        
     
    
    String[] test1 = {
      "#  #  #  E  #  #  #",
      "#  y4 y3 y2 y1 y0 #",
      "#  .  .  $  .  $  #",
      "#  .  .  $  .  .  #",
      "#  .  .  g0 .  .  #",
      "#  #  .  g1 .  .  #",
      "#  #  #  g2 .  .  #",
      "#  #  #  g3 #  .  #",
      "#  #  #  #  #  #  #"
      };
    

    // Since we don't have SnakeUtil.findSnakes implemented
    // yet, we can create the snakes ourselves and use
    // the two-argument constructor for SnakeBasket
//    ArrayList<Snake> snakes = new ArrayList<>();
//    Snake s = new Snake('g');
//    s.addPiece(2, 1); 
//    s.addPiece(3, 1);
//    snakes.add(s);
////   
//    SnakeBasket b = new SnakeBasket(test0, snakes);
    
    // This requires that
    // the resetAllSnakes method has been implemented.
//    System.out.println(b.getCell(2, 1).hasSnake()); // expected true
//    GridUtil.display(b);
//    System.out.println();
    // expected:
//    	 0  1  2  
//    0  #  E  #  
//    1  #  .  #  
//    2  #  g0 #  
//    3  #  g1 #  
//    4  #  #  # 
   
    
//     try the example given as test1, above
    ArrayList<Snake> snakes = new ArrayList<>();

    Snake s = new Snake('g');
    s.addPiece(4, 3);
    s.addPiece(5, 3);
    s.addPiece(6, 3);
//    s.addPiece(7, 3);
    snakes.add(s);
    s = new Snake('y');
    s.addPiece(1, 5);
    s.addPiece(1, 4);
//    s.addPiece(1, 3);
//    s.addPiece(1, 2);
//    s.addPiece(1, 1);
    snakes.add(s);
//////    
//////    // This constructor ignores the snake information in 
//////    // the descriptor (e.g. "g0", "g1", etc, if any) and uses
//////    // the list of snakes we pass in. 
    SnakeBasket b = new SnakeBasket(test1, snakes);
//    System.out.println(b.getCell(2, 1).hasSnake());
//////    
//////    // should look similar to the string array above
    GridUtil.display(b);
//////
//////    // expected
////////   0  1  2  3  4  5  6  
////////0  #  #  #  E  #  #  #  
////////1  #  y4 y3 y2 y1 y0 #  
////////2  #  .  .  .  .  .  #  
////////3  #  .  .  .  .  .  #  
////////4  #  #  #  g0 #  #  #  
////////5  #  #  #  g1 #  #  #  
////////6  #  #  #  g2 #  #  #  
////////7  #  #  #  g3 #  #  #  
////////8  #  #  #  #  #  #  # 
//////    
//////    // try grabbing yellow snake by the head
    b.grabSnake(5, 3);
//    System.out.println(b.currentSnake() != null); // expected true
//    System.out.println(b.currentSnake().getId()); // expected 'y'
//    System.out.println(b.currentWasGrabbedByHead());  // expected true
//    b.move(Direction.UP);
//    GridUtil.display(b);
//    b.move(Direction.UP);
//    GridUtil.display(b);
////    
//    b.releaseSnake();
//    System.out.println(b.currentSnake() != null); // expected false
//////    
//////    // if you grab someplace that isn't a head or tail, 
//////    // it doesn't become the current snake
//    b.grabSnake(1, 4);
//    System.out.println(b.currentSnake() != null); // expected false
//    System.out.println();
////////    
//////    // next, try moving a snake! 
//    System.out.println("Move green snake (head) UP...");
//    b.grabSnake(4, 3); // green snake head
//    System.out.println(b.currentSnake().getPieces());
//////    // expected [(4, 3), (5, 3), (6, 3), (7, 3)]
//
//    b.move(Direction.UP);
////    System.out.println(b.currentSnake().getId());
////    System.out.println(b.currentSnake() != null);
//    System.out.println(b.getMoves());
//    b.move(Direction.LEFT);
//    System.out.println(b.getMoves());
////    System.out.println(b.currentSnake().getId());
////    System.out.println(b.currentSnake() != null);
////    System.out.println(b.currentSnake().getPieces());
//////    // expected [(3, 3), (4, 3), (5, 3), (6, 3)]
//////// 
//    GridUtil.display(b);
//    System.out.println();
//    
//    // should look more or less like this
////       0  1  2  3  4  5  6  
////    0  #  #  #  E  #  #  #  
////    1  #  y4 y3 y2 y1 y0 #  
////    2  #  .  #  #  #  .  #  
////    3  #  .  .  g0 .  .  #  
////    4  #  #  #  g1 #  #  #  
////    5  #  #  #  g2 #  #  #  
////    6  #  #  #  g3 #  #  #  
////    7  #  #  #  .  #  #  #  
////    8  #  #  #  #  #  #  # 
//    
//    // try moving the other snake
//    System.out.println("Move yellow snake (tail) LEFT (does nothing)...");
//    b.releaseSnake();
//    b.grabSnake(1, 1); // yellow snake tail
//    System.out.println(b.currentSnake().getPieces());
//////    // expected [(1, 5), (1, 4), (1, 3), (1, 2), (1, 1)]
//////    
//////    // going left should do nothing, it's a a wall
//    b.move(Direction.LEFT);
//    System.out.println(b.currentSnake().getPieces());
//////    // expected [(1, 5), (1, 4), (1, 3), (1, 2), (1, 1)]
//    System.out.println();
//////    
//    System.out.println("Move yellow snake (tail) DOWN...");
////
//    b.move(Direction.DOWN);
////    b.move(Direction.DOWN);
////    b.grabSnake(2, 1);
// 
//    System.out.println(b.currentSnake().getPieces());
    // expected [(1, 4), (1, 3), (1, 2), (1, 1), (2, 1)]
//    GridUtil.display(b);
//     should look more or less like this
//       0  1  2  3  4  5  6  
//    0  #  #  #  E  #  #  #  
//    1  #  y3 y2 y1 y0 .  #  
//    2  #  y4 #  #  #  .  #  
//    3  #  .  .  g0 .  .  #  
//    4  #  #  #  g1 #  #  #  
//    5  #  #  #  g2 #  #  #  
//    6  #  #  #  g3 #  #  #  
//    7  #  #  #  .  #  #  #  
//    8  #  #  #  #  #  #  # 

    
    String[] test2 = {
    		// 0  1  2  3  4  5
    	      "#  #  E  #  #  #", //0
    	      "#  #  y2 y3 y4 #", //1
    	      "#  .  y1 g0 .  #", //2
    	      "#  .  y0 g1 .  #", //3
    	      "#  g4 g3 g2 #  #", //4
    	      "#  #  #  #  #  #", //5

    	      };
////    
//    Snake s1 = new Snake('g');
//
//    s1.addPiece(2, 3);
//    s1.addPiece(3, 3);
//    s1.addPiece(4, 3);
//    s1.addPiece(4, 2);
//    s1.addPiece(4, 1);
//    snakes.add(s1);
//    s1 = new Snake('y');
//    s1.addPiece(3, 2);
//    s1.addPiece(2, 2);
//    s1.addPiece(1, 2);
//    s1.addPiece(1, 3);
//    s1.addPiece(1, 4);
//    snakes.add(s1);
//    SnakeBasket c = new SnakeBasket(test2, snakes);
////    
//    GridUtil.display(c);
//    System.out.println();
//
//    c.grabSnake(3, 2); 
//    System.out.println(c.currentSnake().getPieces());
//    c.move(Direction.UP);
////    c.move(Direction.DOWN);
// 
//    
//    GridUtil.display(c);
//    System.out.println();
    
////    c.releaseSnake();
////    System.out.println(c.currentSnake().getPieces());
//    c.move(Direction.UP);
//    c.move(Direction.UP);
//    c.releaseSnake();
//    GridUtil.display(c);
//    System.out.println();
//    c.grabSnake(4, 3); 
//    c.move(Direction.LEFT);
//    c.move(Direction.UP);
////    c.move(Direction.UP);
//    System.out.println(c.isOver());
//    GridUtil.display(c);
//    System.out.println();
  }
}
