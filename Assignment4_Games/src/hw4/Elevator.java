package hw4;

import java.util.ArrayList;

import api.GameElement;

/**
 * An Elevator is a GameElement with two distinctive behaviors.  First,
 * it can be set up to move vertically within a fixed set of boundaries.
 * On reaching a boundary, the y-component of its velocity is reversed.
 * Second, it maintains a list of <em>child</em> elements whose basic
 * motion all occurs relative to the Elevator.
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class Elevator extends MovingElement
{
	
	private double up;
	private double down;
	private ArrayList<GameElement> listOfChild;
	
  /**
   * Constructs a new Elevator.  Initially the upper and lower
   * boundaries are <code>Double.NEGATIVE_INFINITY</code> and
   * <code>Double.POSITIVE_INFINITY</code>, respectively.
   * @param x
   *   x-coordinate of initial position of upper left corner
   * @param y
   *   y-coordinate of initial position of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
  public Elevator(double x, double y, int width, int height)
  {
	  super(x, y, width, height);
	    
	  up = Double.NEGATIVE_INFINITY;
	  down = Double.POSITIVE_INFINITY;
	  listOfChild = new ArrayList<GameElement>();
  }

	/**
	 * Sets the upper and lower boundaries for this Elevator's movement
	 * @param min
	 * @param max
	 */
	public void setBounds(double min, double max) {
		
		up = min;
		down = max;
	}
	
	/**
	 * Returns the upper boundary for this Elevator's movement.
	 * @return left boundary
	 */
	public double getMin() {
		
		return up;
	}
	
	/**
	 * Returns the lower boundary for this Elevator's movement.
	 * @return right boundary
	 */
	public double getMax() {
		
		return down;
	}
  
	/**
	 * Adds a child object to this Elevator, and sets this object to be the child's parent.
	 * @param charm
	 */
	public void addChild(Charm charm) {
		
		charm.setPosition(super.getXReal(), super.getYReal());
		
		listOfChild.add(charm);
		
		for (int i = 0; i < listOfChild.size(); ++i) {
			
			charm.setParent(listOfChild.get(i));
		}
	}
	
	/**
	 * Adds a child object to this Elevator, and sets this object to be the child's parent.
	 * @param lurker
	 */
	public void addChild(Lurker lurker) {

		lurker.setPosition(getXReal(), getYReal());
		listOfChild.add(lurker);
		
		for (int i = 0; i < listOfChild.size(); ++i) {
			
			lurker.setParent(listOfChild.get(i));
		}
		
		lurker.setBounds(super.getXReal(), super.getXReal() + super.getWidth());
		
		lurker.getPlatformVelocity(getDeltaX());	//get Velocity of parent to determine its move or not
		lurker.getOxOfLurker(getXReal());	//get the initial Ox of children
		
	}
	
	/**
	 * Returns a list of all this Elevator's children.
	 * @return list of children
	 */
	public java.util.ArrayList<GameElement> getChildren() {
		
		return listOfChild;
	}
	
	/**
	 * Deletes all children that have been marked.
	 */
	public void deleteMarkedChildren() {
		
		for (int i = 0; i < listOfChild.size(); ++i) {
			
			if (listOfChild.get(i).isMarked()) {
				
				listOfChild.remove(listOfChild.get(i));
			}
		}		
		
	}
	
	/**
	 * Updates this object's state for a new frame, and additionally calls update on all its children.
	 */
	@Override
	public void update() {
		
		super.update();
		
		if (getYReal() <= getMin()){
					
			setPosition(getXReal() , getMin());
			setVelocity(getDeltaX(), getDeltaY() * -1);
		}
		
		if (getYReal() >= getMax() - getHeight()) {
			
			setPosition(getXReal(), getMax() - getHeight());
			setVelocity(getDeltaX(), getDeltaY() * -1);
		}
		
		for (int i = 0; i < listOfChild.size(); ++i) {	
			
			listOfChild.get(i).setPosition(super.getXReal(), super.getYReal());
			listOfChild.get(i).update();

		
		}
		
	}
}
