
package hw4;

import api.GameElement;

/**
 * Element associated with parent object such as a Platform or Elevator
 * that moves along with the parent and remains a fixed distance above it.
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class Charm extends BasicElement
{

	private int numOffset;
	private int numHover;

  /**
   * Constructs a new Charm.  Before being added to a parent element
   * such as a Platform or Elevator, the x and y coordinates are zero.  
   * When a parent object is set, the initial x-coordinate becomes
   * the parent's x-coordinate, plus the given offset, and the y-coordinate
   * becomes the parent's y-coordinate, minus this element's height, minus
   * the hover amount.
   * @param width
   *   element's width
   * @param height
   *   element's height
   * @param offset
   *   when a parent is set, this amount is added to the parent's x-coordinate
   *   to calculate this element's x-coordinate
   * @param hover
   *   when a parent is set, this element's y-coordinate is the parent's
   *   y-coordinate, minus this element's height, minus the hover amount
   */
  public Charm(int width, int height, int offset, int hover)
  {
	  
    super(0 ,0 , width, height);
 
    numOffset = offset;
    numHover = hover;
    
  }
  
  /**
   * Set's this element's parent. This element's x-coordinate becomes the parent's x-coordinate, plus the offset, 
   * and the y-coordinate becomes the parent's y-coordinate, minus this element's height, minus the hover amount.
   * @param p - the parent for this element
   */
  public void setParent(GameElement p) {
	  
	  p.setPosition(getXReal() + numOffset, getYReal() - getHeight() - numHover);
  }
  
  /**
   * Updates this element's position to remain stationary relative to the parent element (provided that a parent has been set).
   */
  @Override
  public void update() {
	  
	  super.update();
	  setPosition(getXReal() + numOffset, getYReal() - getHeight() - numHover);
  }



}
