package Exam1;

public class DrinkMachine {
	public static final int PRICE = 150;
	private int numDrink;
	private int maxDrink;
	private int balance;
	private int coinReturn;
	
	public DrinkMachine(int givenCapacity) {
		maxDrink = givenCapacity;
		numDrink = 0;
		balance = 0;
		coinReturn = 0;
	}
	public void insertCoin(int value) {
		balance += value;
	}
	
	public void restock(int howMany) {
		numDrink += howMany;
		numDrink = Math.min(maxDrink,  numDrink);
	}
	
	public int getCount() {
		return numDrink;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int getCoinReturn() {
		return coinReturn;
	}
	
	public void clearCoinReturn() {
		coinReturn = 0;
		balance= 0;
	}
	public void dispense() {
		if (balance == PRICE && numDrink >= 1) {
			numDrink -= 1;
			balance = 0;
		}
		if (balance > PRICE && numDrink >= 1) {
			numDrink -= 1;
			coinReturn = balance - PRICE;
			getCoinReturn();
		}
		if (numDrink == 0 || balance < PRICE) {
			coinReturn = balance;
			balance = 0;
		}
	}
}
