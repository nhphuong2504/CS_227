package Exam1;
import java.util.Scanner;
public class Eggs {
	public static void main (String[] args) {
//		Scanner scnr = new Scanner(System.in);
//		
//		System.out.print("How many eggs: ");
//		int numEggs = scnr.nextInt();
//		
//		System.out.print("Do you want brown eggs (yes / no): ");
//		String brownEggs = scnr.next();
//		
//		int numFlats = 0;
//		int numDozens = 0;
//		int numHalfDozens = 0;
//		double price = 0.0;
//		
//		if (numEggs >= 30) {
//		numFlats = numEggs / 30;
//		numEggs = numEggs % 30;
//		}
//		else {
//			numFlats = 1;
//			numEggs = 0;
//		}
//		
//		if (numEggs >= 12) {
//		numDozens = numEggs / 12;
//		numEggs = numEggs % 12;
//		}
//		
//		else {
//			numDozens = 1;
//			numEggs = 0;
//		}
//		
//		if ( numEggs >= 6) {
//			numHalfDozens = numEggs / 6;
//		}
//		else {
//			
//		}
//		price = (numFlats*6.5 + numDozens*3.0 + numHalfDozens*2.0);
//		if (brownEggs == "yes") {
//			price *= 1.2;
//		}
//		else {
//		}
//		System.out.println(numFlats);
//		System.out.println(numDozens);
//		System.out.println(numHalfDozens);
//		System.out.println("price: " + price);
		Scanner sc = new Scanner(System.in);
        System.out.println("How many eggs? ");
        int eggs = sc.nextInt();

        boolean eggsAreBrown = false;
        System.out.println("Do you want brown eggs? (yes/nno)");
        String s = sc.next();
        if(s.toLowerCase().equals("yes")){
            eggsAreBrown = true;
        }

        int numFlats = 0;
        numFlats += eggs/30;
        eggs = eggs%30;
        if(eggs>24){ // it is cheaper to get 1 flat than 3 dozen
            numFlats+=1;
            eggs = 0; // an extra flat will cover all our egg needs
        }

        int numDozens = 0;
        numDozens += eggs/12;
        eggs %= 12;
        if(eggs>6){ // it is cheaper to buy 1 dozen than 2 half dozens
            numDozens++;
            eggs = 0; // an extra dozen will be more than enough eggs
        }

        int numHalfDozens = 0;
        if(eggs>0){ //if our egg needs haven't been met then we need a half dozen to cover the remainder
            numHalfDozens = 1;
        }

        double price = (numFlats*6.5 + numDozens*3 + numHalfDozens * 2);
        if(eggsAreBrown){
            price *= 1.2;
        }

        System.out.println(numFlats + " flats");
        System.out.println(numDozens + " dozens");
        System.out.println(numHalfDozens + " half dozens");
        System.out.println("Price " + price);
    }
}
