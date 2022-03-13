package lab7;

import java.io.File;

public class countFiles {
	
	 public static int countFile(File f) {
		 
	        int count = 0;

	        if (!f.isDirectory()) {
	        	
	        	return 1;
	            
	        } 
	        else {
	        	
	            File[] files = f.listFiles();
	            
	            for (int i = 0; i < files.length; ++i) {
	            	
	                count += countFile(files[i]);
	            }
	        }

	        return count;
	    }
	public static void main(String[] args)		
	{
	   
	    File rootDirectory = new File(".");

	    System.out.println(countFile(rootDirectory));
	  }

}
