package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer2
{
  public static void main(String[] args) throws FileNotFoundException
  {
    File file = new File("../project5/src/lab5/Lab5Example.java");
    Scanner scanner = new Scanner(file);
    int lineCount = 1;

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      System.out.print(lineCount + " ");
      System.out.println(line);
      lineCount += 1;
    }
    scanner.close();
////    
////    
//////    File file = new File("SimpleLoops.java");
//////    System.out.println(file.exists());          // true if the file exists
//////    System.out.println(file.getName());         // name of the file 
//////    System.out.println(file.getAbsolutePath()); // absolute path to the file
//////    System.out.println(file.length());          // size of the file
//  }
  
	
//	public static void main(String[] args) throws FileNotFoundException
//  {
//		
//	    File file = new File("story.txt");
//	    Scanner scanner = new Scanner(file);
//	    
//	
//	    while (scanner.hasNextLine())
//	    {
////	    	
//	      String line = scanner.nextLine();
//	      countWords(line);
//	    }
//	    scanner.close();
//  }
//	
////	
//  public static void countWords(String line) {
//	  
//	  Scanner temp = new Scanner(line);
//	  int count = 0;
//	  
//	  while (temp.hasNext()) {
//		  
//		  String word = temp.next();
//		  count += 1;
//	  }
//	  System.out.println("The word count of this line is: " + count);
  }
}
