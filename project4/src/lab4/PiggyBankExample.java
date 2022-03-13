package lab4;

public class PiggyBankExample
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    PiggyBank piggy = new PiggyBank(5);
    piggy.addCoins(1);
    piggy.addCoins(1);
    System.out.println("Should contain 2 coins: " + piggy.getNumCoins());
    System.out.println("Should be false (not smashed): " + piggy.isSmashed());
    piggy.addCoins(1);
    System.out.println("Should now contain 3 coins: " + piggy.getNumCoins());
    piggy.addCoins(2);
    System.out.println("Should now contain 5 coins: " + piggy.getNumCoins());
    System.out.println("Should be true: " + piggy.isFull());
    piggy.smash();
    System.out.println("Should now contain 0 coins: " + piggy.getNumCoins());
    System.out.println("Should be false: " + piggy.isFull());
    piggy.addCoins(2);
    System.out.println("Should now contain 0 coins: " + piggy.getNumCoins());
  }

}