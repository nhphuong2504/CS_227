package lab7;

public class getPyramidCount {
	
	public static int getPyramidCount(int n) {
		
		if (n == 1) {
			
			return 1;
		}
		else {
			
			int total = getPyramidCount(n - 1);
			
			return (n*n + total);
		}
	}
//	public static int useLoop(int n) {
//		
//		int total = 0;
//		
//		for (int i = n ; i >= 1; --i) {
//			
//			total = total + i*i;
//		}
//		
//		return total;
//	}
	
	public static void main(String[] args)
	
	  {
	    
	    System.out.println(getPyramidCount(4));
//	    System.out.println(useLoop(8));
	  }
	

}
