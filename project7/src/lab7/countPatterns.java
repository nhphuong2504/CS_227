package lab7;

import java.io.File;

public class countPatterns {
	
	public static int[] bricks = {1,3};
	
	
	public static int countPatterns(int n) {
		
		int count = 0;
		
		if (n == 0) {
			
			return 1;
		}
		
		if (n < 0) {
			
			return 0;
		}
		
		for (int i = 0; i < bricks.length ; ++i) {
			
			count += countPatterns(n - bricks[i]);
		}
		
//		count += countPatterns(n - 1);
//		count += countPatterns(n - 3);
		
		return count;
	}
	
	public static void main(String[] args)		
	{
	   
	    System.out.println(countPatterns(4));
	  }
	
	

}
