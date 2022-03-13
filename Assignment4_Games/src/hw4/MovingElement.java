package hw4;

import java.awt.Rectangle;

import api.GameElement;

/**
 * Concrete implementation of GameElement in which the <code>update</code>
 * method updates the position each frame according to a <em>velocity</em> 
 * vector (deltaX, deltaY).  The units are assumed to be "pixels per frame".
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class MovingElement extends BasicElement
{
	private double numDeltaX;
	private double numDeltaY;

  /**
   * Constructs a MovingElement with a default velocity of zero in
   * both directions.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   object's width
   * @param height
   *   object's height
   */
	  public MovingElement(double x, double y, int width, int height)
	  {
		  super(x, y, width, height);
		  numDeltaX = 0.0;
		  numDeltaY = 0.0;
	  }
	
	@Override
	public void update() {
		
		super.update();
		
		setPosition(getXReal() + getDeltaX(), getYReal() + getDeltaY());
	}
	  
	  //Addition method
	
	/**
	 * Sets the velocity for this object.
	 * @param deltaX
	 * @param deltaY
	 */
	
	public void setVelocity(double deltaX, double deltaY) {
		
		numDeltaX = deltaX;
		numDeltaY = deltaY;
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
