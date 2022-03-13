package Exam1;

public class MachineTest {

	public static void main(String[] args) {
		DrinkMachine dm = new DrinkMachine(10);
		
		dm.insertCoin(100);
		dm.insertCoin(100);
		System.out.println(dm.getBalance()); //200
		dm.dispense();
		System.out.println(dm.getBalance()); //0
		System.out.println(dm.getCoinReturn()); //200
		
		dm = new DrinkMachine(10);
//		dm.restock(9);
		dm.insertCoin(100);
		
		
	}
}
