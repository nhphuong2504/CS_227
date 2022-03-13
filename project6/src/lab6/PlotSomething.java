package lab6;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class PlotSomething {
	
	private static Polyline parseOneLine(String line) {
		
		Scanner words = new Scanner(line);
		int width = 1;
		String color;
		
		//if present, set width of line
		if(words.hasNextInt()) {
			width = words.nextInt();
		}
		
		//set color
		color = words.next();
		
		Polyline thisPoly = new Polyline(color, width);
		
		//read in all of the points;
		while(words.hasNextInt()) {
			int a = words.nextInt();
			int b = words.nextInt();
			thisPoly.addPoint(new Point(a, b));
		}
		return thisPoly;
	}
	
	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		
		ArrayList<Polyline> arrList = new ArrayList<Polyline>();
		
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			
			String line = sc.nextLine();
			
			if(line.length() > 0 && !line.startsWith("#")) {
		    	  
				arrList.add(parseOneLine(line));
			}
		}
		sc.close();
		return arrList;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	  {
	    ArrayList<Polyline> list = readFile("hello.txt");
	    Plotter plotter = new Plotter();

	    for (int i = 0; i < list.size(); ++i)
	    {
	      plotter.plot(list.get(i));
	    }
	  }

}
