package mini3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import snakes.api.Direction;
import snakes.api.GridUtil;
import snakes.api.SnakePiece;
import snakes.hw3.Snake;
import snakes.hw3.SnakeBasket;

/**
 * Class that manages the state information during a recursive
 * search for solutions to the SnakeEscape game.
 */
public class SnakeSolver
{
  /**
   * Maximum number of moves allowed in the search.
   */
  private int maxMoves;
  
  /**
   * Associates a signature with the move count to reach 
   * that grid layout.
   */
  private Map<String, Integer> seen = new HashMap<String, Integer>();
  
  /**
   * All solutions found in this search.
   */
  private ArrayList<String> solutions = new ArrayList<>();
  
  /**
   * Constructs a solver with the given maximum number of moves.
   * @param givenMaxMoves
   *   maximum number of moves
   */
  public SnakeSolver(int givenMaxMoves)
  {
    maxMoves = givenMaxMoves;
  }
  
  /**
   * Returns all solutions found in the search.  Each solution 
   * is a single string in the form returned by SnakeBasket#getMoveList.
   * @return
   *   list of all solutions
   */
  public ArrayList<String> getSolutions()
  {
    return solutions;
  }
  
  /**
   * Recursively search for solutions to the given game instance
   * according to the algorithm described in the miniassignment 3
   * pdf.
   * @param game
   *   any instance of SnakeBasket
   */
  private Scanner sc = new Scanner(System.in);
  public void solve(SnakeBasket game)
  {

//	 System.out.println(game.getMoveList());
//
//	System.out.println(game.getSignature());
//	
//	System.out.println(game.isOver());
//	 System.out.println("Press ENTER to continue...");
//
//	 sc.nextLine();
	 
    if (game.getMoves() > maxMoves) {
    	
    	return;
    }
    
    else if (game.isOver()) {
    	
    	solutions.add(game.getMoveList());
    	return;
    	
    }
    
    else if (seen.containsKey(game.getSignature())) {
    	
    	if (game.getMoves() >=  seen.get(game.getSignature())) {
    		
    		return;

    	}
    	else {
    		seen.put(game.getSignature(), game.getMoves());
    	}
    }
    else {
    	seen.put(game.getSignature(), game.getMoves());
    	
    	
    }
    for (int i = 0 ; i < game.getAllSnakes().size() ; ++ i) {
    	
    	Snake s = game.getAllSnakes().get(i);
    	 	
    	int a = s.getHead().row();
    	int b = s.getHead().col();
    	
    	game.grabSnake(s.getHead().row(), s.getHead().col());
    	
    	game.move(Direction.LEFT);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	 	
    	if (b - 1 == s.getHead().col()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    	
    	game.grabSnake(s.getHead().row(), s.getHead().col());
    	
    	game.move(Direction.RIGHT);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	  	
    	if (b + 1 == s.getHead().col()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    	game.grabSnake(s.getHead().row(), s.getHead().col());
    	
    	game.move(Direction.UP);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	   	
    	if (a - 1 == s.getHead().row()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    	
    	game.grabSnake(s.getHead().row(), s.getHead().col());
    	
    	game.move(Direction.DOWN);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	
    	
    	if (a + 1 == s.getHead().row()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    	
    	int x = s.getTail().row();
    	int y = s.getTail().col();
    	
    	game.grabSnake(s.getTail().row() , s.getTail().col());
    	
    	game.move(Direction.LEFT);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	   	
    	if (y - 1 == s.getTail().col()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    	
    	game.grabSnake(s.getTail().row(), s.getTail().col());
    	
    	game.move(Direction.RIGHT);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	
    	
    	if (y + 1 == s.getTail().col()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}	
    	
    	game.grabSnake(s.getTail().row(), s.getTail().col());
    	
    	game.move(Direction.UP);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	
    	if (x - 1 == s.getTail().row()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    	
    	game.grabSnake(s.getTail().row(), s.getTail().col());
    	
    	game.move(Direction.DOWN);
    	game.releaseSnake();
    	
//    	System.out.println(game.getMoveList());
//    	System.out.println(game.getSignature());
    	
    	
    	if (x + 1 == s.getTail().row()) {
    		
    		solve(game);
        	game.undoMove();
        	
//        	System.out.println(game.getMoveList());
//        	System.out.println(game.getSignature());
    	}
    }
  }

}
