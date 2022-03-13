package lab2;

public class StringTest {

	public static void main(String[] args) {
		String message;
		
		message = "Hello, world!";
		System.out.println(message);
		
		int theLength = message.length();
		System.out.println(theLength);
		
		char theChar = message.charAt(message.length() - 1);
		System.out.println(theChar);
		
		String thelastIndex = message.trim();
		System.out.println(thelastIndex);
		
//		theChar = message.charAt(12);
//		System.out.println(theChar);
//		
//		String UpperCase = message.toUpperCase();
//		System.out.println(UpperCase);
//		
//		String theSubstring = message.substring(6, 10);
//		System.out.println(theSubstring);

	}

}
