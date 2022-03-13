
package hw4;

import api.GameElement;

/**
 * Moving element associated with a Platform or Elevator.  Optionally,
 * a Lurker can be given a nonzero horizontal velocity and it will oscillate
 * between the left and right edges of the Platform or Elevator.
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class Lurker extends MovingElement
{
	
	private int numOffset;
	private double left;
	private double right;
	
	private double flVelocityOx;	//the velocity of parent
	private double temp;
	private double distance;		
	
  /**
   * Constructs a new Lurker.  Before being added to a parent element
   * such as a Platform or Elevator, the x and y coordinates are zero.  
   * When a parent element is set, the initial x-coordinate becomes
   * the parent's x-coordinate, plus the given offset, and the y-coordinate
   * becomes the parent's y-coordinate, minus this element's height.
   * @param width
   *   element's width
   * @param height
   *   element's height
   * @param initialOffset
   *   when a parent is set, this amount is added to the parent's x-coordinate
   *   to calculate this element's initial x-coordinate
   */
  public Lurker(int width, int height, int initialOffset)
  {
	  super(0 ,0 , width, height);
	  numOffset = initialOffset;
	  left = Double.NEGATIVE_INFINITY;
	  right = Double.POSITIVE_INFINITY;
	  temp = 0.0;
	  distance = initialOffset;
  }
  
  /**
   * Set's this element's parent. This element's x-coordinate becomes the parent's x-coordinate, plus the initial offset, 
   * and the y-coordinate becomes the parent's y-coordinate, minus this element's height.
   * @param p - the parent of this object
   */
  public void setParent(GameElement p) {
	  
	  p.setPosition(getXReal() + numOffset, getYReal() - getHeight());
  }
  
  /**
   * Sets the right and left boundaries for this Lurker's movement. This method normally has no effect in practice, 
   * since the Lurker is typically associated with a parent element such as a Platform or Elevator, which determines its boundaries.
   * @param min
   * @param max
   */
  public void setBounds(double min, double max) {
	  
	  left = min;
	  right = max;
  }
  
  /**
   * Returns the left boundary for this Lurker's movement.
   * @return left boundary
   */
  public double getMin() {
	  
	  return left ;
  }
  
  /**
   * Returns the right boundary for this Lurker's movement.
   * @return rights boundary
   */
  public double getMax() {
	  
	  return right;
  }

  /**
   * Updates this element's position to move horizontally according to its velocity (possibly zero) relative to the parent object, 
   * and remain "resting" on the parent object (provided that a parent has been set). 
   * Upon reaching the left or right boundary of the parent, the horizontal velocity is reversed.
   */
  public void update() {
	  
//	  super.update();
	  
	  
	  if (flVelocityOx == 0 && getDeltaX() != 0) {			//platform not move, lurker move
		  
		  setPosition(temp + getDeltaX(), getYReal());
		  temp = getXReal();
		  
	  }
	  
	  else if (flVelocityOx != 0 && getDeltaX() == 0) {		//platform move, lurker not move
		  
		  setBounds(getXReal(), getXReal() + (getMax() - getMin()));
		  		  
		  setPosition(getXReal() + numOffset, getYReal());
		  
	  }
	  
	  else if (flVelocityOx != 0 && getDeltaX() != 0) {		//platform move, lurker move
		  
		  setBounds(getXReal(), getXReal() + (getMax() - getMin()));
		  
		  setPosition(getXReal() + distance + getDeltaX(), getYReal());
		  
		  distance += getDeltaX();

		  
	  }
	  
	  setPosition(getXReal(), getYReal() - getHeight());	//update the position to Oy
	  
	  if (getXReal() <= getMin())	{						//check if lurker meet boundaries 
			
		  	distance = distance + (getMin() - getXReal());
			setPosition(getMin() , getYReal());
			setVelocity(getDeltaX() * -1, getDeltaY());
			temp = getXReal();
	  }
		
	  if (getXReal() >= getMax() - getWidth()) {
		  
		  	distance = distance - (getXReal() + getWidth() - getMax());
			setPosition(getMax() - getWidth(), getYReal());
			setVelocity(getDeltaX() * -1, getDeltaY());
			temp = getXReal();
		}
  }

  
  /**
   * Help method to get the velocity of parent
   * @param velocityOx
   */
  
  protected void getPlatformVelocity(double velocityOx) {
	  
	  flVelocityOx = velocityOx;

  }
  
  /**
   * Help method to get the initial Ox of Children
   * @param initialOxOfLurker
   */
  protected void getOxOfLurker(double initialOxOfLurker) {
		  
	  
	  temp = initialOxOfLurker + numOffset;
  }
  
  
}
