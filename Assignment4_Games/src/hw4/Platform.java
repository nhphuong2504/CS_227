package hw4;

import java.util.ArrayList;

import api.GameElement;

/**
 * A Platform is a GameElement with two distinctive behaviors.  First,
 * it can be set up to move horizontally within a fixed set of boundaries.
 * On reaching a boundary, the x-component of its velocity is reversed.
 * Second, it maintains a list of <em>child</em> elements whose basic
 * motion all occurs relative to the Platform.
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class Platform extends MovingElement
{
  
	private double left;
	private double right;
	private ArrayList<GameElement> listOfChild;
	
  /**
   * Constructs a new Platform. Initially the left and right
   * boundaries are <code>Double.NEGATIVE_INFINITY</code> and
   * <code>Double.POSITIVE_INFINITY</code>, respectively.
   * @param x
   *   x-coordinate of initial position of upper left corner
   * @param y
   *   y-coordinate of initial position of upper left corner
   * @param width
   *   object's width
   * @param height
   *   object's height
   */
  public Platform(double x, double y, int width, int height)
  {
    super(x, y, width, height);
    
    left = Double.NEGATIVE_INFINITY;
    right = Double.POSITIVE_INFINITY;
    listOfChild = new ArrayList<GameElement>();
  }
	
	/**
	 * Sets the left and right boundaries for this Platform's movement
	 * @param min
	 * @param max
	 */
	public void setBounds(double min, double max) {
		
		left = min;
		right = max;
	}
	
	/**
	 * Returns the left boundary for this Platform's movement.
	 * @return left boundary
	 */
	public double getMin() {
		
		return left;
	}
	
	/**
	 * Returns the left boundary for this Platform's movement.
	 * @return right boundary
	 */
	public double getMax() {
		
		return right;
	}
	
	/**
	 * Adds a child object to this Platform, and sets this object to be the child's parent.
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
	 * Adds a child object to this Platform, and sets this object to be the child's parent.
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
		lurker.getOxOfLurker(getXReal());			//get the initial Ox of children
		
	}
	
	/**
	 * Returns a list of all this Platform's children.
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
		
		if (getXReal() <= getMin()){
					
			setPosition(getMin() , getYReal());
			setVelocity(getDeltaX() * -1, getDeltaY());
		}
		
		if (getXReal() >= getMax() - getWidth()) {
			
			setPosition(getMax() - getWidth(), getYReal());
			setVelocity(getDeltaX() * -1, getDeltaY());
		}
		
		for (int i = 0; i < listOfChild.size(); ++i) {	
			
			listOfChild.get(i).setPosition(super.getXReal(), super.getYReal());
			listOfChild.get(i).update();
			
				
		}
	}
}

