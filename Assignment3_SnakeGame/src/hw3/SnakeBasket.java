package hw3;
import static api.Direction.DOWN;
import static api.Direction.LEFT;
import static api.Direction.RIGHT;
import static api.Direction.UP;

import java.util.ArrayList;
//import static Status;

import api.BasketCell;
import api.Direction;
import api.SnakeLayoutException;
import api.SnakePiece;
import api.GridUtil;

/**
 * This class represents the basic game state for a "Snake Escape" 
 * game, including a 2d grid of cells and a list of snakes.
 * @author Hoang Phuong Nguyen
 */
public class SnakeBasket
{
  /**
   * The 2D array of cells.
   */
  private BasketCell[][] grid; 
  
  /**
   * The list of snakes.
   */
  private ArrayList<Snake> snakes;
  
  
  // TODO: any other instance variables you need
  /**
   * the single s
   */
  private Snake s;
  
  /**
   * Tracking if the snake grabbed at head
   */
  private boolean isHead;
  
  /**
   * Tracking if the snake grabbed at tail
   */
  private boolean isTail;
  
  /**
   * Tracking game is over or not
   */
  private boolean gameEnd;
  
  /**
   * Count how many steps the snake moves
   */
  private int countMove;
  
  /**
   * the number represent the id of snake in list of snakes
   */
  private int id;
  
  
  /**
   * Constructs an instance of this game from the given string
   * array and list of snakes.  <em>Snake information, if any,
   * in the given string array is ignored</em>.
   * @param desc
   *    array of strings representing the initial grid layout
   * @param givenSnakes
   *    array of snakes
   */
  public SnakeBasket(String[] desc, ArrayList<Snake> givenSnakes)
  {
    grid = GridUtil.createGridFromDescriptor(desc);
    snakes = givenSnakes;
    
    resetAllSnakes();
    
    countMove = 0;
    gameEnd = false;
    isHead = false;
    isTail = false;
    id = -1;
    

  }
  
  /**
   * Constructs an instance of this game from the given string
   * array.
   * @param desc
   *    array of strings representing the initial grid layout,
   *    including ids and placement of snakes
   */
  public SnakeBasket(String[] desc)
  {
    grid = GridUtil.createGridFromDescriptor(desc);
    snakes = SnakeUtil.findSnakes(desc);
    
    resetAllSnakes();
    
  }
  
  /**
   * Returns the grid cell at the given row and column.
   * @param row
   *    given row
   * @param col
   *    given column
   * @return
   *    grid cell at the given row and column
   */
  public BasketCell getCell(int row, int col)
  {
    return grid[row][col];
  }
  
  /**
   * Returns the number of rows in this game.
   * @return
   *   number of rows
   */
  public int getRows()
  {
    return grid.length;
  }
  
  /**
   * Returns the number of columns in this game.
   * @return
   *   number of columns
   */
  public int getCols()
  {
    return grid[0].length;
  } 
  
  /**
   * Returns the currently grabbed snake, if any.  Returns
   * null if there is no current snake.
   * @return
   *   current snake, if any
   */
  public Snake currentSnake()
  {

	  if (isHead || isTail) {		//if snake grabbed head or tail
		  
		  return snakes.get(id);	//the currently grabbed snake
	  }
	  else {
		  return null;
	  }
    
  }
  
  
  /**
   * Returns true if there is a current snake and it was 
   * grabbed at the head end, false if it was grabbed by
   * the tail.
   * @return
   *   true if current snake was grabbed by the head
   */
  public boolean currentWasGrabbedByHead()
  {
	  if (isHead) {
		  
		  return true;
	  }
	  else {
		  return false;
	  }
  }
  
  /**
   * Returns this SnakeBasket's list of all snakes. Normally this
   * method is used to easily render or display the game;
   * clients should not modify the list or the snakes.
   * @return
   *   list of all snakes
   */
  public ArrayList<Snake> getAllSnakes()
  {
    return snakes;
  }
  
  /**
   * Returns true if the green snake is in the 
   * exit cell, false otherwise.
   * @return
   *   true if green snake is in the exit
   */
  public boolean isOver()
  {
    return gameEnd;
  }
  
  /**
   * Returns the total number of moves that have been made so far
   * in this game.
   * @return
   *   number of moves
   */
  public int getMoves()
  {
    return countMove;
  }
  
  
  /**
   * Attempts to grab a snake by the head or tail at the given position.
   * If there is not already a current snake, and if the given position 
   * contains a snake head or tail, that becomes the current snake. 
   * If this game already has a current snake selected, this method
   * does nothing. 
   * @param row
   *   given row at which to grab a snake
   * @param col
   *   given column at which to grab a snake
   */
  public void grabSnake(int row, int col)
  {
	  if (currentSnake() == null) {			//If there is not already a current snake
		  
		  for (int i = 0 ; i < snakes.size(); ++i) { 
			  		 			
			  if (snakes.get(i).isHead(row, col)) { //if the given position is snake head
				  
				  isHead = true;	
				  id = i;
				  currentSnake();			//set this snake is current snake
				  break;
			  }
			  
			  else if (snakes.get(i).isTail(row, col)) {	////if the given position is snake tail
				  
				  isTail = true;
				  id = i;
				  currentSnake();			////set this snake is current snake
				  break;
					
			  }
		  }
	  }
	  else {		//if already have current snake, do nothing
		  
	  }
			 	  
  }
  
  /**
   * Sets the current snake to null, if any.
   */
  public void releaseSnake()
  {
	 isHead = false; 
	 isTail = false;
	 currentSnake();	//Sets the current snake to null
  }
  
  /**
   * Attempt to move the current snake (head or tail) to an adjacent
   * cell in the given direction.  If a move is possible, this method
   * updates the current snake, the move count, and the grid cells
   * (via resetAllSnakes).
   * <p>
   * It is only possible to move in the following cases:
   * <ul>
   *   <li>The adjacent cell is empty; then the snake (head or tail) moves 
   *       into the cell
   *   <li>The adjacent cell is the exit and the current snake is the green one;
   *       then the snake (head or tail) moves into the exit and the game ends
   *   <li>The current snake was grabbed by the head, and the adjacent cell
   *       is row/column of the current snake's tail; then the snake (head) moves
   *       into the cell
   *   <li>The current snake was grabbed by the tail, and the adjacent cell
   *       is row/column of the current snake's head; then the snake (tail)
   *       moves into the cell
   *   <li>The current snake was grabbed by the head and the adjacent cell
   *   is an apple; then the apple is removed and the snake (head) moves 
   *   into the cell, increasing its size by one piece
   *   <li>The current snake was grabbed by the head, has at least three pieces,
   *    and the adjacent cell is a mushroom; then the mushroom is removed and
   *    the snake (head) moves into the cell, reducing its size by one piece
   * </ul>
   * If none of the above conditions is met, this method does nothing.
   * If any of the conditions is met and a move occurs, the move count
   * is increased by 1.
   * If there is no currently grabbed snake, this method does nothing.
   * @param dir
   *   Direction in which to attempt to move
   */
  public void move(Direction dir)
  { 
	  if (currentSnake() == null) { //If there is no currently grabbed snake, this method does nothing.
		  
	  }
	  else { 
		  
		  SnakePiece testSnake = currentSnake().getHead();	//get the piece of the current snake head
		  int rowHead = testSnake.row();					//row of the current snake head
		  int colHead = testSnake.col();					//column of the current snake head
		  
		  testSnake = currentSnake().getTail();			//get the piece of the current snake tail
		  int rowTail = testSnake.row();				//row of the current snake tail
		  int colTail = testSnake.col();				////column of the current snake tail
		  
		  
		  if (dir == UP) {
			  
			  if (currentWasGrabbedByHead()) {	//if The current snake was grabbed by head
				  
				  if (getCell(rowHead - 1, colHead ).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit 
					  																			  //and the current snake is the green one; 
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowHead - 1, colHead ).isEmpty()) { ////if The adjacent cell on top is empty
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowHead - 1 == rowTail && colHead == colTail) { //the adjacent cell is row/column of the current snake's tail
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead - 1, colHead ).isApple()) {	//if the adjacent cell is an apple
					  
					  getCell(rowHead - 1, colHead ).clearFood();
					  currentSnake().moveHeadAndGrow(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead - 1, colHead ).isMushroom() && currentSnake().getPieces().size() >= 3) {	//if the adjacent cell is a mushroom and the current snake has at least 3 pieces
					
					  getCell(rowHead - 1, colHead ).clearFood();
					  currentSnake().moveHeadAndShrink(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
			  }
			  
			  else {							////if The current snake was grabbed by tail
				  
				  if (getCell(rowTail - 1, colTail ).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit and the current snake is the green one;
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowTail - 1, colTail ).isEmpty()) { //if The adjacent cell on top is empty
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowTail - 1 == rowHead && colTail == colHead) { //if the adjacent cell is row/column of the current snake's head
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }		  
			  }
				  
		  }
		  else if (dir == DOWN) {
			  
			  if (currentWasGrabbedByHead()) {	//if The current snake was grabbed by head
				  
				  if (getCell(rowHead + 1, colHead ).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit 
					  																			  //and the current snake is the green one; 
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowHead + 1, colHead ).isEmpty()) { ////if The adjacent cell on bot is empty
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowHead + 1 == rowTail && colHead == colTail) { //the adjacent cell is row/column of the current snake's tail
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead + 1, colHead ).isApple()) {	//if the adjacent cell is an apple
					  
					  getCell(rowHead + 1, colHead ).clearFood();
					  currentSnake().moveHeadAndGrow(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead + 1, colHead ).isMushroom() && currentSnake().getPieces().size() >= 3) {	//if the adjacent cell is a mushroom and the current snake has at least 3 pieces
					  
					  getCell(rowHead + 1, colHead ).clearFood();
					  currentSnake().moveHeadAndShrink(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
			  }
			  
			  else {							////if The current snake was grabbed by tail
				  
				  if (getCell(rowTail + 1, colTail ).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit and the current snake is the green one;
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowTail + 1, colTail ).isEmpty()) { //if The adjacent cell on top is empty
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowTail + 1 == rowHead && colTail == colHead) { //if the adjacent cell is row/column of the current snake's head
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }		  
			  }
		  }
		  
		  else if (dir == LEFT) {
			  
			  if (currentWasGrabbedByHead()) {	//if The current snake was grabbed by head
				  
				  if (getCell(rowHead, colHead - 1).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit 
					  																			  //and the current snake is the green one; 
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowHead, colHead - 1 ).isEmpty()) { ////if The adjacent cell on left is empty
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowHead == rowTail && colHead -1 == colTail) { //the adjacent cell is row/column of the current snake's tail
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead, colHead  - 1).isApple()) {	//if the adjacent cell is an apple
					  
					  getCell(rowHead, colHead - 1).clearFood();
					  currentSnake().moveHeadAndGrow(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead, colHead - 1).isMushroom() && currentSnake().getPieces().size() >= 3) {	//if the adjacent cell is a mushroom and the current snake has at least 3 pieces
					  
					  getCell(rowHead, colHead - 1).clearFood();
					  currentSnake().moveHeadAndShrink(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
			  }
			  
			  else {							////if The current snake was grabbed by tail
				  
				  if (getCell(rowTail, colTail - 1).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit and the current snake is the green one;
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowTail, colTail - 1).isEmpty()) { //if The adjacent cell on top is empty
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowTail == rowHead && colTail - 1 == colHead) { //if the adjacent cell is row/column of the current snake's head
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }		  
			  }
		  }
		  
		  else if (dir == RIGHT) {
			  
			  if (currentWasGrabbedByHead()) {	//if The current snake was grabbed by head
				  
				  if (getCell(rowHead, colHead + 1).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit 
					  																			  //and the current snake is the green one; 
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowHead, colHead + 1).isEmpty()) { ////if The adjacent cell on right is empty
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowHead == rowTail && colHead + 1 == colTail) { //the adjacent cell is row/column of the current snake's tail
					  
					  currentSnake().moveHead(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead, colHead + 1).isApple()) {	//if the adjacent cell is an apple
					  
					  getCell(rowHead, colHead + 1).clearFood();
					  currentSnake().moveHeadAndGrow(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (getCell(rowHead, colHead + 1).isMushroom() && currentSnake().getPieces().size() >= 3) {	//if the adjacent cell is a mushroom and the current snake has at least 3 pieces
					  
					  getCell(rowHead, colHead + 1).clearFood();
					  currentSnake().moveHeadAndShrink(dir);
					  resetAllSnakes();
					  countMove += 1;
				  }
			  }
			  
			  else {							////if The current snake was grabbed by tail
				  
				  if (getCell(rowTail, colTail + 1).isExit() && currentSnake().getId() == 'g') { //if The adjacent cell is the exit and the current snake is the green one;
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
					  gameEnd = true;
				  }
				  
				  else if (getCell(rowTail, colTail + 1).isEmpty()) { //if The adjacent cell on top is empty
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }
				  
				  else if (rowTail == rowHead && colTail + 1 == colHead) { //if the adjacent cell is row/column of the current snake's head
					  
					  currentSnake().moveTail(dir);  
					  resetAllSnakes();
					  countMove += 1;
				  }		  
			  }
		  }
	
		  else {		//do nothing
			  
		  }
	  }
  } 
   
  /** 
   * Clears all snake information from the grid, if any, and then
   * sets it from the current list of snakes.  After executing 
   * this method, the information in the grid cells and the
   * information in the snake list should be fully consistent.
   */
  public void resetAllSnakes()
  {
	  int row = 0;
	  int col = 0;
	  for (row = 0; row < grid.length ; ++ row) {	//iterate every cell to clear snake
		  
		  for (col = 0; col < grid[0].length ; ++ col) {
			  	  
			  if (getCell(row,col).hasSnake()) {
				  
				  getCell(row,col).clearSnake();	//clear snake if there is snake in the cell
			  }
 		 
		  }
		  
	  }
	  
	  for (int i = 0 ; i < snakes.size(); ++i) {	//iterate the list of snakes to access every single snake 
		  
		  s = snakes.get(i);
		  
		  ArrayList<SnakePiece> pieces = s.getPieces();
		  
		  for (int j = 0; j < pieces.size(); ++j)	//iterate the snake to add piece to the grid
		    { 
		      SnakePiece p = pieces.get(j);
		      row = p.row(); 
		      col = p.col();
		      
		      grid[row][col].setSnake(s);			//set the snake to the position on the grid
		    }	  
	  }

	  }
}
