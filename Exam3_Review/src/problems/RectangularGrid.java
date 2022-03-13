package problems;

public class RectangularGrid {
	
	public static int RectangularGrid(int r, int c) {
		
		
		if (r == 0 || c  == 0) {
			
			return 1;
		}
		
		return RectangularGrid(r - 1, c) + RectangularGrid(r, c - 1);
	}

	public static void main(String[] args) {
		
		int count = RectangularGrid(1, 2);
		
		System.out.println(count);

	}

}
