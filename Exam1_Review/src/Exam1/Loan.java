package Exam1;

public class Loan {
//	double rate;
//	double balance;
//	double monthRate;
//	
//	public Loan(double interestRate, double initialBalance) {
//		rate = interestRate;
//		balance = initialBalance; 
//		monthRate = rate / 12 * balance;
//	}
//	
//	public void makePayment(double payment) {
//		balance = balance + monthRate - payment;
//		monthRate = rate / 12 * balance;
//	}
//	
//	public double getBalance() {
//		return balance;
//	}
//	
//	public double getPayOffAmount() {
//		return balance + monthRate;
//	}
	private int rainbow;
	public Loan(int givenRainbow) {
		rainbow = givenRainbow;
	}
	
	public int dream(int pixieDust) {
		int unicorn = pixieDust;
		if (unicorn > rainbow) {
			unicorn = rainbow * 3;
		}
		if (unicorn < 20) {
			if (unicorn < 0) {
				unicorn = rainbow;
				rainbow = 100;
			}
			else {
				unicorn = rainbow * 2;
			}
		}
		return unicorn;
	}
}
