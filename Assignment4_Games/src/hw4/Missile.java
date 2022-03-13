package hw4;

/**
 * Moving element in which the vertical velocity is adjusted
 * each frame by a gravitational constant to simulate gravity.
 * It may also be put into a "ballistic" state in which 
 * no other modifications to velocity take place other than gravity.
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class Missile extends BasicElement
{

	private double numDeltaX;
	private double numDeltaY;
	private boolean curBallistic;
	private double numGravity;
	
  /**
   * Constructs a new Missile.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
  public Missile(double x, double y, int width, int height)
  {
    super(x, y, width, height);
    
    numDeltaX = 0.0;
    numDeltaY = 0.0;
    curBallistic = false;
    numGravity = 0.0;
    

  }
  
  /**
   * Updates position and adds the gravitational constant to the y-component of the velocity.
   */
  @Override
  public void update() {
	  
	  super.update();
	  
	  super.setPosition(super.getXReal() + getDeltaX() , super.getYReal() + getDeltaY());
	  
	  numDeltaY += numGravity;
	 
  }

  //Addition method
  
  /**
   * Sets the velocity for this element, but does nothing if the element is currently ballistic.
   * @param deltaX - new horizontal velocity
   * @param deltaY - new vertical velocity
   */
  public void setVelocity(double deltaX, double deltaY) {
	  
	  if (!isBallistic()) {
		  
		  numDeltaX = deltaX;
		  numDeltaY = deltaY;
		  
	  }
	  
  }
  
  /**
   * Sets the gravitational constant, assumed to be in units of "pixels per frame per frame". Remember that the positive direction is down.
   * @param gravity - gravitational constant to use
   */
  public void setGravity(double gravity) {
	  
	  numGravity = gravity;
  }
  
  /**
   * Sets or unsets the ballistic state of this Missile.
   * @param ballistic - true if ballistic, false otherwise
   */
  public void setBallistic(boolean ballistic) {
	  
	  curBallistic = ballistic;
  }
  
  /**
   * Determines whether this Missile is in a ballistic state.
   * @return true if ballistic, false otherwise
   */
  public boolean isBallistic() {
	  
	  return curBallistic;
  }
  
  /**
   * Returns the x-component of this object's velocity.
   * @return horizontal velocity
   */
  public double getDeltaX() {
	  
	  return numDeltaX;
  }
  
  /**
   * Returns the y-component of this object's velocity.
   * @return vertical velocity
   */
  public double getDeltaY() {
	  
	  return numDeltaY;
  }

}
