package hw3;

import java.util.ArrayList;
import static api.Direction.*;
import api.Direction;
import api.SnakePiece;

/**
 * A Snake is a sequence of (row, column) pairs in which each 
 * (row, column) in the sequence represents a 2d position that is
 * horizontally or vertically adjacent to the previous one.
 * Each (row, column) is represented by an instance of the
 * class SnakePiece.  The first piece in the sequence
 * is called the "head", and the last one is called the
 * "tail".  In addition to the list of SnakePiece objects,
 * a Snake has an id consisting of a single character.
 * <p>
 * A snake may or may not be <em>valid</em>.  More precisely,
 * a snake is defined to be valid if:
 * <ul>
 *   <li>It has at least two pieces
 *   <li>There are no null elements in its pieces list
 *   <li>There are no duplicates in its pieces list
 *   <li>Each piece in the list has a row and column
 *   position that is horizontally or vertically adjacent
 *   to the previous piece in the list
 * </ul>
 * The methods to add pieces to a snake do 
 * NOT do any error-checking.  Instead, clients can use the method 
 * isValid to check whether the snake is valid.
 * @author Hoang Phuong Nguyen
 */
public class Snake
{
  
	/**
	 * ID of the snake
	 */
	private char id = ' ';	
	
	/**
	 * piece of the snake
	 */
	private ArrayList <SnakePiece> snake;  	
	

  /**
   * Constructs a Snake with an empty list of SnakePiece objects
   * and with the given character as its ID.
   * @param givenId
   *   ID to use for this Snake
   */
  public Snake(char givenId)
  {
	  id = givenId;
	  snake = new ArrayList<SnakePiece>();
  }
  
  
  /**
   * Adds a new SnakePiece to the end of  this Snake's list of pieces.  This 
   * method does no error-checking to ensure the given position is actually 
   * adjacent to the current tail.
   * @param row
   *   row for the new SnakePiece
   * @param col
   *   column for the new SnakePiece
   */
  public void addPiece(int row, int col)
  {  
	  
	  snake.add(new SnakePiece(row, col));

  }

  
  /**
   * Sets this Snake's list of pieces at the given index to be a new
   * SnakePiece with the given row and column.  If the current list 
   * of pieces is shorter than the given index, it is padded with
   * nulls so the given index can be set. This method does no 
   * error-checking to ensure the given (row, column) is actually 
   * adjacent to its neighbors in the list of pieces.
   * @param index
   *   index in the list of pieces where the new SnakePiece will be set
   * @param row
   *   row for the new SnakePiece
   * @param col
   *   column for the new SnakePiece
   */
  public void addPiece(int index, int row, int col)
  {  
	  if (snake.size() == 0) {					
		  
		  for (int i = 0; i <= index ; ++i) {
	  		  
			  snake.add(i, null);				//set up list snake with length = "index" and with indexes = null
		  }
		  snake.set(index, new SnakePiece(row, col));	//set the last piece of snake into piece we want to add
	  }
	  
	  else if (snake.size() - 1 < index ) { 		//if index we want to add bigger than the snake size
		  
		  for (int i = snake.size(); i <= index ; ++i) {
			  		  
			  snake.add(i, null);
		  }
		  snake.set(index, new SnakePiece(row, col));
	  }
	  else if (snake.size() - 1 >= index ) {		//if we want to add at the already index in snake
		  
		  snake.set(index, new SnakePiece(row, col));
	  }
  }
  
  /**
   * Returns the ID for this Snake.
   * @return
   *   ID for this Snake
   */
  public char getId()
  {
	  return id;
  }
  
  /**
   * Returns true if the ID is one of the characters 'g' or 'G'.
   * @return
   *   true if ID is 'g' or 'G'
   */
  public boolean isGreen()
  {
	  if (id == 'g' || id == 'G') {
		  
		  return true;
	  }
    return false;
  }
  
  /**
   * Returns the first piece in this Snake's list of pieces,
   * or null if this snake has no pieces.
   * @return
   *   first piece
   */
  public SnakePiece getHead()
  {
	  
	  if (snake.size() == 0) {
		  
		  return null;
	  }
    return snake.get(0);
  }
  
  /**
   * Returns the last piece in this Snake's list of pieces, or 
   * null if this snake has no pieces.
   * @return
   *   last piece
   */
  public SnakePiece getTail()
  {
	if (snake.size() == 0) {
			  
		return null;
	}
    return snake.get(snake.size() - 1) ;
  }
  
  /**
   * Returns true if given row and column match the row and column 
   * of this Snake's first piece.
   * Returns false if this snake has no pieces.
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   true if the head of this Snake has the same row and column
   */
  public boolean isHead(int row, int col)
  {
	  SnakePiece checkHead = new SnakePiece(row,col);
	  
	  if (snake.size() == 0) {				////if this snake has no pieces
		  
			return false;
	  }
	  
	  if (checkHead.equals(snake.get(0))) {		//if given row and column match the row and column of this Snake's first piece.
		  
		  return true;
	  }
	  
	  return false;
  }
  
  /**
   * Returns true if given row and column match the row and column 
   * of this Snake's last piece.  Returns false if this snake has no pieces.
   * 
   * @param row
   *   given row
   * @param col
   *   given column
   * @return
   *   true if the tail of this Snake has the same row and column
   */
  public boolean isTail(int row, int col)
  {
	  
	  SnakePiece checkTail = new SnakePiece(row,col);
	  
	  if (snake.size() == 0) { 			//if this snake has no pieces
		  
			return false;
	  }
	  
	  if (checkTail.equals(snake.get(snake.size() - 1))) {	//if given row and column match the row and column of this Snake's last piece.
		  
		  return true;
	  }
	  
	  return false;
  }
   
  /**
   * Returns this Snake's list of pieces. Normally this
   * method is used to render or display the game; clients
   * should not directly modify the snakes through this method.
   * @return
   *   list of SnakePiece objects for this Snake
   */
  public ArrayList<SnakePiece> getPieces()
  {
	  
	  return snake;
  }
  
  /**
   * Moves the head of this Snake in the given direction without
   * changing its length. Does nothing if the snake has fewer than
   * two pieces.
   * @param dir
   *   which direction
   */
  public void moveHead(Direction dir)
  {
		  
	  SnakePiece head = getHead();		//take the piece of snake head
		  
	  int rowHead = head.row();			//access row of snake head
	  int colHead = head.col();			//access column of snake head
	  
	  if (dir == UP) {
		  
		  snake.add(0, new SnakePiece(rowHead - 1, colHead));	//add new piece into head
		  snake.remove(snake.size() - 1);						//remove the piece of tail
	  }
	  else if (dir == DOWN) {
		  
		  snake.add(0, new SnakePiece(rowHead + 1, colHead));
		  snake.remove(snake.size() - 1);
	  }
	  else if (dir == RIGHT) {
	  
		  snake.add(0, new SnakePiece(rowHead, colHead + 1));
		  snake.remove(snake.size() - 1);
	  }
	  else if (dir == LEFT) {
	  
		  snake.add(0, new SnakePiece(rowHead, colHead - 1));
		  snake.remove(snake.size() - 1);
	  }
  }
  
  
  /**
   * Moves the tail of this Snake in the given direction without
   * changing its length. Does nothing if the snake has fewer than
   * two pieces.
   * @param dir
   *   which direction
   */
  public void moveTail(Direction dir)
  {
	  SnakePiece tail = getTail();		//take the piece of snake tail
	  
	  int rowTail = tail.row();			//access row of snake tail
	  int colTail = tail.col();			//access column of snake tail
	  
	  if (dir == UP) {
		  
		  snake.add(snake.size(), new SnakePiece(rowTail - 1, colTail));	//add new piece into tail
		  snake.remove(0);													//remove the piece of head
	  }
	  else if (dir == DOWN) {
		  
		  snake.add(snake.size(), new SnakePiece(rowTail + 1, colTail));
		  snake.remove(0);
	  }
	  else if (dir == RIGHT) {
	  
		  snake.add(snake.size(), new SnakePiece(rowTail, colTail + 1));
		  snake.remove(0);
	  }
	  else if (dir == LEFT) {
	  
		  snake.add(snake.size(), new SnakePiece(rowTail, colTail - 1));
		  snake.remove(0);
	  }
  } 
  
  /**
   * Moves the head of this Snake in the given direction, increasing
   * its length by 1. Does nothing if the snake has fewer than
   * two pieces.
   * @param dir
   *   which direction
   */
  public void moveHeadAndGrow(Direction dir)
  {
	  SnakePiece head = getHead();		//take the piece of snake head
	  
	  int rowHead = head.row();			//access row of snake head
	  int colHead = head.col();			//access column of snake head
	  
	  if (dir == UP) {
		  
		  snake.add(0, new SnakePiece(rowHead - 1, colHead));	//add new piece into head
	  }
	  else if (dir == DOWN) {
		  
		  snake.add(0, new SnakePiece(rowHead + 1, colHead));
	  }
	  else if (dir == RIGHT) {
	  
		  snake.add(0, new SnakePiece(rowHead, colHead + 1));
	  }
	  else if (dir == LEFT) {
	  
		  snake.add(0, new SnakePiece(rowHead, colHead - 1));
	  }
  }
  
  /**
   * Moves the head of this Snake in the given direction, decreasing
   * its length by 1.  Does nothing if this Snake fewer than three pieces.
   * @param dir
   *   which direction
   */
  public void moveHeadAndShrink(Direction dir) ////moveHeadAndShrink discards two pieces at the end so the length decreases by 1
  {
	  SnakePiece head = getHead();		//take the piece of snake head
	  
	  int rowHead = head.row();			//access row of snake head
	  int colHead = head.col();			//access col of snake head
	  
	  if (snake.size() < 3) {			//Does nothing if this Snake fewer than three pieces.
		  
	  }
	  else {
		  
	  
		  if (dir == UP) {
			  
			  snake.add(0, new SnakePiece(rowHead - 1, colHead));	//add new piece into head
			  snake.remove(snake.size() - 1);						//remove last 2 pieces
			  snake.remove(snake.size() - 1);
		  }
		  else if (dir == DOWN) {
			  
			  snake.add(0, new SnakePiece(rowHead + 1, colHead));
			  snake.remove(snake.size() - 1);
			  snake.remove(snake.size() - 1);
		  }
		  else if (dir == RIGHT) {
		  
			  snake.add(0, new SnakePiece(rowHead, colHead + 1));
			  snake.remove(snake.size() - 1);
			  snake.remove(snake.size() - 1);
		  }
		  else if (dir == LEFT) {
		  
			  snake.add(0, new SnakePiece(rowHead, colHead - 1));
			  snake.remove(snake.size() - 1);
			  snake.remove(snake.size() - 1);
		  }
	  }
  }
  
  
  /**
   * Determines whether this snake is valid.  A snake is
   * <em>valid</em> if 
   * <ul>
   *   <li>It has at least two pieces
   *   <li>There are no null elements in its pieces list
   *   <li>There are no duplicates in its pieces list
   *   <li>Each piece in the list has a row and column
   *   position that is horizontally or vertically adjacent
   *   to the previous piece in the list
   * </ul>
   * @return
   *   true if this snake is valid, false otherwise
   */
  public boolean isValid()
  {
	  boolean result = true;
	  
	  if (snake.size() < 2) {	//It has at least two pieces
		  
		  result = false;
	  }
	  else {
			  
		  for (int i = 0; i < snake.size(); ++i) {		//There are no null elements in its pieces list
			  
			  if (snake.get(i) == null) {
					  
				  result = false;
			  }
		  }
		  
			  if (result == true) {					//There are no duplicates in its pieces list
				  
				  int m = 0;
				  
				  for (m = 0; m <= snake.size() - 2; ++m) {
						 
					  int n = m + 1;
					  SnakePiece testSnake = snake.get(m);
					  int rowHead = testSnake.row();			
					  int colHead = testSnake.col();

					  while (n <= snake.size() - 1) {
						  
						  SnakePiece testSnake2 = snake.get(n);
						  int rowHead2 = testSnake2.row();			
						  int colHead2 = testSnake2.col();
						  
						  if ((rowHead2 == rowHead && colHead2 == colHead)) {
								  
							  result = false;	
						  }
						   
						  n += 1;
					  }
				  }				  
			  
			  }
		  
	  }
		  
	  if (result == true) {		//Each piece in the list has a row and column position that is 
		  						//horizontally or vertically adjacent to the previous piece in the list	  
		  int k = 0; 
		  int j = 1;
		  
		  while (k <= snake.size() - 2) {
					  
			  SnakePiece testSnake = snake.get(k);
			  int rowHead = testSnake.row();			
			  int colHead = testSnake.col();	
	
			  while( j <= snake.size() - 1) {
				  
				  SnakePiece testSnake2 = snake.get(j);
				  int rowHead2 = testSnake2.row();			
				  int colHead2 = testSnake2.col();
				  
				  if (rowHead2 == rowHead && (colHead2 == colHead + 1 || colHead2 == colHead - 1)) {
					  
					  result = true;
				  }
				  
				  else if (colHead2 == colHead && (rowHead2 == rowHead + 1 || rowHead2 == rowHead - 1)) {
					  
					  result = true;
				  }
				  
				  else {
					  
					  result = false;
				  }
				  
				  k += 1;
				  j += 1; 
				  break;
			 }
		  }
	  }
	  
	  return result;
  }
}

