package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api.GridUtil;
import api.SnakeLayoutException;

/**
 * Utility methods for working with Snakes.
 * @author Hoang Phuong Nguyen
 */
public class SnakeUtil
{
  /**
   * Private constructor disables instantiation.
   */
  private SnakeUtil() {}
  
  /**
   * Given a descriptor array, return a list of all the snakes
   * it contains. Snake pieces are represented in the descriptor
   * array by id strings consisting of a single character followed
   * by a number. All other text elements in the descriptor are single 
   * characters only and are ignored by this method.  
   * The first character of the id string
   * becomes the "id" for the Snake. The number following
   * the id becomes the actual list index for the corresponding piece
   * of the snake.  For example, if row 3 and column 5 of the 
   * descriptor is the string "g7", then the snake with id 'g' should
   * have, at index 7 of its pieces list, a SnakePiece with row 3, column 5 .
   * <p>
   * This method first calls GridUtil.validateDescriptor, which may
   * throw a SnakeLayoutException.  In addition, after constructing
   * the list of snakes, this method checks isValid() on each
   * snake and throws SnakeLayoutException if any snake is found
   * to be invalid.
   * <p>
   * The order of snakes within the returned list is unspecified.
   * @param desc
   *   descriptor array
   * @return
   *   list of snakes in the descriptor
   * @throws SnakeLayoutException
   *   if the descriptor fails to pass GridUtil.validateDescriptor
   *   or if any of the resulting snakes is invalid
   */
  public static ArrayList<Snake> findSnakes(String[] desc)
  {
	  ArrayList<Snake> snakes = new ArrayList<>();  //empty list of snake
	  
	  int rows = desc.length;		// number of rows
	  String firstRow = desc[0];
	  String[] tokens = firstRow.split("\\s+");
	  int cols = tokens.length;		//// number of cols	
	  
	  for (int row = 0; row < rows ; ++row) {
		  
		  String s = desc[row];
	      tokens = s.split("\\s+");
	      
		  for (int col = 0; col < cols; ++ col) {
			  
			  String t = tokens[col];	//check every single token of row,col
			  
			  if (t.length() > 1) {		//if token have length > 1
				  
				  char c = t.charAt(0);			//first character of token is the id of snake
				  char temp = t.charAt(1);
				  int index = Character.getNumericValue(temp); 	//second character of token is the number of index
				  
				 if (snakes.size() == 0) {		//create first snake
					 
					 Snake newSnake = new Snake(c);	//create a new snake
					 newSnake.addPiece(index, row, col);	//add piece at index position
					 snakes.add(newSnake);			//add to the list of snake

				 }
				 else {
					 boolean newOrAdd = false;			//create to track we should create new snake or add to the available snake
					 
					 for (int i = 0; i < snakes.size(); ++i) {	
						  
						  if (snakes.get(i).getId() == c) { // find the snake with the same token
							  
							  newOrAdd = true;		//add to available snake
							  snakes.get(i).addPiece(index, row, col);	
							  break;
						  }
					 }
					 if (!newOrAdd) {	//create new snake
						 
						 Snake newSnake = new Snake(c);	//create a new snake
						 newSnake.addPiece(index, row, col);	//add piece at index position
						 snakes.add(newSnake);
					 }
							  
				 }

			  }			  
		  }
	  }

	  return snakes;
  }

  
  /**
   * Reads a the given file and creates a string array from
   * each block of text separated by whitespace. The string
   * arrays are returned in an ArrayList.  Despite the name
   * of this method, it does NO checking for whether
   * a given block of text actually represents a descriptor
   * for the game.  The file is assumed to end with a blank line.
   * @param filename
   *   name of the file to read
   * @return
   *   ArrayList of string arrays, one for each block of text
   * @throws FileNotFoundException
   *   if the named file cannot be opened
   */
  public static ArrayList<String[]> createDescriptorsFromFile(String filename) throws FileNotFoundException
  {
	  ArrayList<String[]> list = new ArrayList<String[]>();
	  ArrayList<String> block = new ArrayList<String>();
  
	  File file = new File(filename);
	  Scanner sc = new Scanner(file);
	 
	  while (sc.hasNextLine()) {
		  
		  String line = sc.nextLine();
		  
		  if (line.length() == 0) {
			  
			  if (block.size() > 0) {		//got the end of the block of text
				  
				  String[] arrBlock = new String[block.size()];
				  
				  for (int i = 0; i < block.size(); ++i) {	//convert list to String[]
					 
					  arrBlock[i] = block.get(i);
				  }
				   
				  list.add(arrBlock);			//add String[] to main list
				  block.clear();				//clear the list
			  }
			 
		  }
		  else {
			  
			  block.add(line);
		  }	  
	  }
	  sc.close();
	  return list;
  }
 
}
