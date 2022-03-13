package lab7;

public class ArrayMax {
	
	
	public static void main(String[] args)
	  {
	    int[] test = {3, 4, 0, 1, 7, 3, 9}; 
	    int result = arrayMax(test);
	    System.out.println(result);
	  }
	
	public static int arrayMax(int[] arr)
	  {
	    return arrayMaxSup(arr, 0, arr.length - 1);
	  }
	
	private static int arrayMaxSup(int[] arr, int start, int end) {
		
		if (start == end) {
			
			return arr[start];
		}
		
		else {
			
			int mid = (start + end) / 2;
			
			int left = arrayMaxSup(arr, start, mid);
			int right = arrayMaxSup(arr, mid + 1, arr.length - 1);
			
			if (left >= right) {
				
				return left;
			}
			else {
				
				return right;
			}
		
	}
	}

}
