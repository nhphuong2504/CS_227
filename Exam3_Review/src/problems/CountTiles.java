package problems;

import java.util.ArrayList;

public class CountTiles {
	
	public static ArrayList<String> result = new ArrayList<String>();
	
	public static int CountTiles(int n) {
		
//		int[] tiles = {1,2,3};
		
		int count = 0;
		
		if (n == 0) {
			
			return 1;
		}
		
		if (n < 0) {
			
			return 0;
		}
		
//		for (int i = 0; i < tiles.length; ++i) {
//			
//			count += CountTiles(n - tiles[i]);
//		}
		
		count += CountTiles(n - 1);
		count += CountTiles(n - 2);
		count += CountTiles(n - 3);
		
		return count;
	}
	
	private static ArrayList getTiles(int n, ArrayList<String> ls, String st) {
		
		if (n <= 0) {
			
			return ls;
		}
		
		if (n == 1) {
			
			ls.add(st + "1");
		}
		
		if (n == 2) {
					
			ls.add(st + "2");
		}
		
		if (n == 3) {
			
			ls.add(st + "3");
		}
		
		getTiles(n - 1, ls, st + "1");
		getTiles(n - 2, ls, st + "2");
		getTiles(n - 3, ls, st + "3");
		return ls;
		
		
	}
	
	public static ArrayList<String> getListOfTiles(int n) {
		
		ArrayList<String> list = new ArrayList<String>();
		String s = "";
		
		getTiles(n, list, s);
		
		return list;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getListOfTiles(5));
		System.out.println(CountTiles(5));
		
	}

}
 