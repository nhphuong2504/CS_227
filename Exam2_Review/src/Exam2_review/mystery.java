package Exam2_review;

public class mystery {
	
	public static void mysterys(String s) {
		
		String result = "";
		int i = 0;
		while (result.length() < 5) {
			
			try {
				
				char c = s.charAt(i);
				result += c;
				i = i + 2;
			}
			catch (StringIndexOutOfBoundsException e) {
				
				i = i - 3;
			}
			finally {
				
				System.out.println(result);
			}
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		mysterys("ABCDE");
	}

}
