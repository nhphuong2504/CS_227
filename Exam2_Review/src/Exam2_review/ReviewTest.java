package Exam2_review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewTest {
	
	public static double averageCount(double[] name) {
		
		double ave = 0.0;
		int count = 0;
		for (int i = 0; i < name.length ; i ++) {
			
			ave += name[i];
			count += 1;
		}
	
		return ave/count;


	}
	public static String LongestWord(String s) {
		
		Scanner sc = new Scanner(s);
		String max = sc.next();

		while (sc.hasNext()) {
			
			int i = max.length();
			String temp = sc.next();
			int k = temp.length();
			
			if ( k > i ) {
				max = temp;
			}
		}
		return max;
	}
	public static String nonAlphabetic(String s) {
		
	
		char ch = ' ';
		String result = "";
		
		for  (int i = 0; i < s.length(); ++i) {
			
			ch = s.charAt(i);
			
			if (Character.isAlphabetic(ch)) {
				
				result = result + ch;
			}
			else {
				result = result + '#';
		
			}
		}
			return result;
	}
	public static int interestMonth(double inst, double balance) {
		
		double result  = balance * 2;
		int i = 0;
		
		while ( result >= balance) {
			
			balance = balance + balance * inst;
			i = i + 1;
		}
		
		return i;
	}
	public static boolean IncreaseOrder(ArrayList<Integer> list) {
		
		int k = list.get(0);	
		for (int i = 1; i < list.size(); ++ i) {
			
			int a = list.get(i);
			if ( a > k) {
				k = a;
			}
			else {
				return false;
			}
		}
		return true;
	}
	public static int IndexOfFirstVowel(String s) {
		
		char ch = ' ';
		int j;
		for (j = 0; j < s.length() ; ++j) {
			
			ch = s.charAt(j);
			
			if ("aeiouAEIOU".indexOf(ch) >= 0) {
				
				return j;
			}
		}
		return -1;
	}
	public static boolean Duplicate(String s) {
		
		for (int i = 0; i < s.length(); ++i) {
			
			char ch = s.charAt(i);
			
			for (int j = i + 1; j < s.length(); ++j) {
				
				char c =s.charAt(j);
				
				if (ch == c) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void enigma (int x, int y) { //2
		 
		while (x > 0){
			if (x % 2 == 0){
				y = y + 1;
			}
			else {
				x = x + 2;
			}
			x = x - y;
			System.out.println(x + ", " + y);
		}
	}
	
	public static void Reverse(int[] arr) {
		
		for (int i = 0; i < arr.length / 2; ++i) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		for (int j = 0; j < arr.length; j ++) {
			
			System.out.println(arr[j]);
		}
	}
	
	public static boolean Permutation(int[] arr) {
		
		for (int i =0; i < arr.length; ++i) {
			
			for (int j = i + 1; j < arr.length; ++j) {
				
				if (arr[i] == arr[j]) {
					
					return false;
				}

			}
		}
		return true;
	}
	public static void Star(int n) {
		for (int i = 0; i <= n; ++i) {
			for (int j = n - i; j >= 0; --j) {
				System.out.print(" ");
			}
			System.out.println('*');
		}
	}
	
	public static double[] AverageCol(double[][] arr) {
		
		double[] a = new double[arr[0].length];

		for (int row = 0; row < arr.length ; ++row) {
			
			for (int col = 0; col < arr[0].length ; ++ col) {

				a[col] = a[col] + arr[row][col];
			}
		}
		for (int i = 0 ; i < a.length; ++i) {
			
			a[i] = a[i] / arr.length;
		}
		return a;
	}
	
	public static int maxCol(int[][] arr) {

		int[] a = new int[arr[0].length];
		int index = 0;
		for (int row = 0; row < arr.length; ++row) {
			for (int col = 0; col < arr[0].length; ++ col) {

				a[col] = a[col] + arr[row][col];
			}
		}
		for (int i = 1 ; i < a.length; ++i) {
			int max = a[0];
			if (a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}
	
	//4
	public static void whatever (int[] arr)
	 {
		int i = 0;
		for (int count = 0; count < arr.length; count += 1)
		{
			if (arr[i] % 2 != 0)
			{
				for (int j = i; j < arr.length - 1; j += 1)
				{
					arr[j] = arr[j + 1];
				}
				arr[arr.length - 1] = 0;
			}
			else
			{
				i += 1;
			}
		}
	 }
	
	//5
	public static String getPassword() {
		
		String pw1 = " ";
		boolean check = false;
		while (!check) {
			
			System.out.print("Enter your password: ");
			Scanner sc = new Scanner(System.in);
			pw1 = sc.nextLine();
			System.out.print("Retype your password: ");
			sc = new Scanner(System.in);
			String pw2 = sc.nextLine();
			if (pw1.equals(pw2)) {
				check = true;
			}

		}
		return pw1;
	}
	public static void mystery(int x)
	  {
	if (x == 1) {
	      System.out.println("pooh");
	    }
	    else if (x % 2 == 0)
	    {
	    	mystery(x / 2);
	      System.out.println(x);    
//	      mystery(x / 2);           
	    }
	else {
	      mystery(x - 1);
	    }
	}
	

	public static boolean whoKnows(int[] arr, int i, int j)
	  {
	if (i >= j) {
		
	      return true;
	    }
	
	else {
		
	      int mid = (i + j) / 2;
	      boolean leftOk = whoKnows(arr, i, mid);
	      boolean rightOk = whoKnows(arr, mid + 1, j);
	      return leftOk && rightOk && arr[mid] <= arr[mid + 1];
	} 
	}
	
	public static int[][] problem1m(int w, int h, int[] arr) {
		
		int[][] result = new int[h][w];
		int i = 0;

		for ( int row = 0 ; row < h ; ++row) {
			for (int col = 0 ; col < w; ++ col) {

				result[row][col] = arr[i];
				i = i + 1;
			}
		}
		
		return result;
	}
	
	public static int problem1n(int n) {

		boolean check = false;
		int i = 1;

		int result = 0;
		
		if (n == 1) {
			return 2;
		}
		
		if (n == 2) {
			return 3;
		}
		
		else {
			while (!check) {
				
				result = n + i;
	
				for (int j = 2; j < result - 1; ++j) {
	
					if (result % j != 0) {
						check = true;
					}
					if (result % j == 0) {
						check = false;
						break;
					}
				}
				i += 1;
	
			}
		}
		return result;
	}
	
	public static void problem1o(int[] arr) {
		
		for (int i = 0 ; i < arr.length ; ++i) {
			
			int check = arr[i];
			
			for (int k = i + 1; k < arr.length; ++k) {
				
				
				if (check == arr[k]) {
	
					for (int j = k ; j < arr.length -1; ++j) {
	
						arr[j] = arr[j+1];
					}
					arr[arr.length - 1] = 0;
	
				}
			}
		}
	}
	public static int mystery1(int x) {
		
		if (x <= 0) {
			System.out.println("boo");
			return 3;
		}
		else {
			int temp = x + mystery1(x - 1);
			System.out.println(temp);
			return temp;
		}
	}
	
	public static int howManyTerms(double target) {
		int term = 0;
		
		double result = 0.0;
		
		int i = 2;
		
		while (result < target) {
			 
			 result = result + 1.0/i;
			 i += 1;
			 term += 1;
		 }
		 
		return term;
	}
	
	public static void removeRuns(int[] arr) {
		for (int i = 0; i < arr.length - 1 ; ++i) {
			
			if (arr[i] != arr[i+1]) {
				
			}
			else {
				for (int j = i ; j < arr.length -1 ; ++j) {
					
					arr[j] = arr[j+1];
				}
				arr[arr.length - 1] = 0;

			}
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		
//		int[] arr = {6,3,4,5,5,2,7,9,8};
//		
//		System.out.println(averageCount(arr));
		
		//
		
//		String str = "nguyen, hoang+ phuongg";
		
//		System.out.println(LongestWord(str));
		
		//
		
//		System.out.println(nonAlphabetic(str));
		
		//
//		double ins = 0.05;
//		double balance = 250;
//		
//		System.out.println(interestMonth(ins, balance));
		
		//
//		ArrayList<Integer> arrlist = new ArrayList<Integer>();
//		arrlist.add(0);
//		arrlist.add(-1);
//		arrlist.add(3);
//		arrlist.add(4);
//		arrlist.add(5);
//		System.out.println(IncreaseOrder(arrlist));
		
		//
//		String str = "Nguyen";
//		System.out.println(Duplicate(str));
		//
//		enigma(12, 0);
		//
//		Reverse(arr);
//		System.out.println(Permutation(arr));
//		Star(5);
		
//		int[][] test = new int[2][3];
//		test[0][0] = 1;
//		test[0][1] = 2;
//		test[0][2] = 3;
//		test[1][0] = 4;
//		test[1][1] = 5;
//		test[1][2] = 6;
//		
//		System.out.println(maxCol(test));
		
//		Scanner sc = new Scanner(System.in);
//
//		String nameFile = sc.next();
//		File file = new File(nameFile);
//		Scanner scnr = new Scanner(file);
//
//		ArrayList<String> list = new ArrayList<String>();
//		while (scnr.hasNextLine()) {
//			String line = scnr.nextLine();
//			int index = line.indexOf("//");
//			if (index == -1) {
//				list.add(line);
//			}
//			else {
//				list.add(line.substring(0, index));
//			}
//		}
//		scnr.close();
//		for (int i = 0; i < list.size(); ++i) {
//			System.out.println(list.get(i));
//		}
		
		//
		
//		whatever(arr);
//		for (int i = 0; i < arr.length; ++i) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println(getPassword());
//		mystery(1);
		
//		System.out.print(whoKnows(arr, 1, 3));
//		int[] arr = {2,2,3,2,5,6,7,2,9};
//		int[][] result = problem1m(3,3,arr);
//		for ( int row = 0 ; row < result.length ; ++row) {
//			for (int col = 0 ; col < result[0].length; ++ col) {
//
//				System.out.print(result[row][col] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(problem1n(7));
//		problem1o(arr);
//		for (int i = 0; i < arr.length ; ++i) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println(mystery1(4));
		
//		String line = "0.0032 3.234 Hello my friends";
//		
//		Scanner sc = new Scanner(line);
//		
//		double a = sc.nextDouble();
////		String i = sc.next();
////		String j = sc.next();
//		double b = sc.nextDouble();
//		String c = sc.nextLine();
//		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
		System.out.println(howManyTerms(1.0));
		
//		int i = 1;
//		
//		double a = 0.0;
//		System.out.print(a = a + (double) 1/2);
//		int[] arr = {1,2,2,2,3,4,5,6};
//		
//		removeRuns(arr);
//		
//		for (int i = 0; i < arr.length ; ++i) {
//			System.out.print(arr[i] + " ");
//		}

	}
}
