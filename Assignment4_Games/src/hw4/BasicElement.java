package hw4;

import java.awt.Rectangle;

import api.GameElement;

/**
 * Minimal concrete extension of GameElement. The <code>update</code>
 * method in this implementation just increments the frame count.
 * 
 * @author HOANG PHUONG NGUYEN
 */
// TODO: This class must directly or indirectly extend GameElement
public class BasicElement extends GameElement 
{
	private double xCoor;
	private double yCoor;
	private int eWidth;
	private int eHeight;
	private boolean isMarkedDeletion;
	private int numFrames;

  
  /**
   * Constructs a new BasicElement.
   * @param x
   *   x-coordinate of upper left corner
   * @param y
   *   y-coordinate of upper left corner
   * @param width
   *   element's width
   * @param height
   *   element's height
   */
	public BasicElement(double x, double y, int width, int height) {
		  
		super();
		xCoor = x;
		yCoor = y;
		eWidth = width;
		eHeight = height;
		isMarkedDeletion = false;
		numFrames = 0;
		  
	}

	@Override
	public int getXInt() {
		// TODO Auto-generated method stub
		return  (int) Math.round(xCoor);
	}
	
	@Override
	public int getYInt() {
		// TODO Auto-generated method stub
		return (int) Math.round(yCoor);
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return eWidth;
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return eHeight;
	}
	
	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
	}
	
	@Override
	public void setPosition(double newX, double newY) {
		// TODO Auto-generated method stub
		xCoor = newX;
		yCoor = newY;
		
	}
	
	@Override
	public double getXReal() {
		// TODO Auto-generated method stub
		return xCoor;
	}
	
	@Override
	public double getYReal() {
		// TODO Auto-generated method stub
		return yCoor;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		numFrames += 1;
		
	}
	
	@Override
	public int getFrameCount() {
		// TODO Auto-generated method stub
		return numFrames;
	}
	
	@Override
	public boolean isMarked() {
		// TODO Auto-generated method stub
		return isMarkedDeletion;
	}
	
	@Override
	public void markForDeletion() {
		// TODO Auto-generated method stub
		isMarkedDeletion = true;
		
	}
	
	@Override
	public boolean collides(GameElement other) {
		// TODO Auto-generated method stub
		return getRect().intersects(other.getRect());
	}

}
