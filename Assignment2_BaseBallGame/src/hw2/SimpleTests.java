package hw2;

public class SimpleTests
{
  public static void main(String[] args)
  {
	  Corkball game = new Corkball(3);

////	  System.out.println(game);
//    
//	  game.strike​(false);
//	  System.out.println(game);  // one strike
//	  game.strike​(false);
//	  System.out.println(game);  // 0 strikes, one out
//	  game.strike​(false);
//	  System.out.println(game);  // one strike, one out
//	  game.strike​(false);
//	  System.out.println(game);  // 0 strike, two outs
//    
//	  game.strike​(true); // batter is immediately out for swung strike
//	  System.out.println(game.isTopOfInning()); // should be false now
////	  System.out.println(game);         // bottom of 1st inning, 0 outs
//	  game.strike​(true);
//	  System.out.println(game);
//	  game.strike​(true);
//	  System.out.println(game);
//	  game.strike​(true);
//	  System.out.println(game);
//	  System.out.println(game.isTopOfInning()); // should be false now
//	  System.out.println(game);         // bottom of 1st inning, 0 outs
//	  System.out.println(game.gameEnded()); 
//	  game.strike​(true);
//	  game.strike​(true);
//	  game.strike​(true);
//	  System.out.println(game); 
//	  System.out.println(game.gameEnded()); 
//	  game.strike​(true);
//	  game.strike​(true);
//	  game.strike​(true);
//	  System.out.println(game); 
//	  System.out.println(game.gameEnded()); 
//	  game.strike​(true);
//	  game.strike​(true);
//	  game.strike​(true);
//	  System.out.println(game); 
//	  System.out.println(game.gameEnded()); 
//	  game.strike​(true);
//	  game.strike​(true);
//	  game.strike​(true);
//	  System.out.println(game); 
//	  System.out.println(game.gameEnded()); 
	  
    // try some hits, look at the bases
//    game = new Corkball(3);
//	  game.hit​(15);
//    System.out.println(game.runnerOnBase(1)); // true
//    System.out.println(game.getBases());      // Xoo    
//    game.hit​(15);
//    System.out.println(game.getBases());      // XXo   
//    game.hit​(15);
//    System.out.println(game.getBases());      // XXX
//    game.hit​(15);
//    System.out.println(game.getBases());      // XXX
//    System.out.println(game.getTeam0Score()); // 1
//    
////     try hitting a double now
//	game.hit​(150);
//    System.out.println(game.getBases());      // oXX
//    System.out.println(game.getTeam0Score()); // 3
////
//    // try counting balls
//    game = new Corkball(3);
//    game.ball();
//    System.out.println(game.getBallCount()); // 1
//    game.ball();
//    System.out.println(game.getBallCount()); // 2
//    game.ball();
//    System.out.println(game.getBallCount()); // 3
//    game.strike​(true);
//    System.out.println(game.getBallCount()); // 0, since it's a new batter
//    
//    // effect of a walk on the runners on base
//    game = new Corkball(3);
//    game.hit​(225);  // a triple
//    System.out.println(game.getBases());  // ooX   
//    game.ball();
//    game.ball();
//    game.ball();
//    game.ball();
//    System.out.println(game.getBallCount()); // 4
//    game.ball();  //  a walk 
//    System.out.println(game.getBases());  // XoX 
	  //Scenario 1
	  
//	  game = new Corkball(3);
//	  game.hit(300);
////	  System.out.println(game);
//	  game.hit(8);
//	  game.hit(2);
//	  game.ball();
//	  game.ball();
//	  game.hit(175);
//	  game.ball();
//	  game.ball();
//	  game.ball();
//	  game.strike(false);
//	  game.hit(225);
//	  game.ball();
//	  game.ball();
//	  game.strike(false);
////	  game.strike(true);
//	  System.out.println(game);
//	  System.out.println(game.getBases());  
//	  System.out.println(game.getBallCount());
//	  System.out.println(game.getTeam0Score()); 
//	  System.out.println(game.getTeam1Score()); 
	  
//	  Scenario 2
//	  game = new Corkball(3);
//	  game.hit(175);
//	  game.hit(175);
//	  game.strike(true);
//	  game.strike(true);
//	  game.ball();
//	  game.ball();
//	  game.strike(false);
////	  game.caughtFly();
//	  System.out.println(game);
//	  System.out.println(game.getBases());  
	  
	  //Scenario 3
	  game = new Corkball(3);
	  game.hit(175);
	  game.hit(20);
	  
	  game.ball();
	  game.ball();
	  game.strike(false);
	  game.ball();
	  game.ball();
	  game.ball();
	  
////	  System.out.println(game.getBallCount());
	  game.strike(false);
	  game.ball();
	  game.ball();
	  game.strike(false);
	  game.strike(false);
	  game.ball();
	  game.ball();
	  game.ball();
	  game.hit(225);
	  
	  game.ball();
	  game.caughtFly();
	  game.strike(false);
	  game.ball();
//	  game.strike(false);
	  System.out.println(game);
	  System.out.println(game.getBases());
//	  game = new Corkball(3);
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  game.caughtFly();
//	  System.out.println(game);
//	  System.out.println(game.getBases());
	  
//	  game.hit(175);
//	  game.hit(225);
//	  System.out.println(game);
//	  System.out.println(game.getBases());
	  
  }
}
