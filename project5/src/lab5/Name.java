package lab5;
import java.util.Scanner;
public class Name {
	
	public static void main(String[] args) {
//		String test = initialName("Hoang phuong Nguyen");
//		System.out.println(test);
		int test1 = indexOfFirstVowel("123 23e");
		System.out.println(test1);
		
//		Scanner scnr = new Scanner(System.in);
//		System.out.print("Name: ");
//		String fullName = scnr.nextLine();
////		}
////	public static String initialName(String fullName) {
//		
//		Scanner sc = new Scanner(fullName);
//		String last = "";
//		
//		while (sc.hasNext()) {
//			
//			String tem = sc.next();
//			char c = tem.charAt(0);
//			last = last + c;
//		}
////		return last;
//		System.out.println("Initial Name: " + last);
	}
	
	
	
	public static int indexOfFirstVowel(String word){
			    
	    for (int i = 0; i < word.length(); i++)
	    {

	    	char ch = word.charAt(i);
	    	if ("aeiouAEIOU".indexOf(ch) >= 0) {
	    		
	    		return i;
	    	}
	    }
	    return -1;
	}

}
