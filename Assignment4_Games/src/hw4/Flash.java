
package hw4;

/**
 * Implementation of GameElement that does not move. Instead, it is intended to
 * appear on the screen for a fixed number of frames.
 * 
 * @author HOANG PHUONG NGUYEN
 */
//TODO: This class must directly or indirectly extend GameElement
public class Flash extends BasicElement
{

	private int numFrames;

  /**
   * Constructs a new Flash.
   * 
   * @param x
   *          x-coordinate of upper left corner
   * @param y
   *          y-coordinate of upper left corner
   * @param width
   *          element's width
   * @param height
   *          element's height
   * @param initialLife
   *          the number of frames until this element marks itself for deletion
   */
	  public Flash(double x, double y, int width, int height, int initialLife)
	  {
		  
	    super(x, y, width, height);
	    
	    numFrames = initialLife;
	  }
  
	/**
	 * Returns the number of frames remaining until this element marks itself for deletion
	 * @return number of remaining frames
	 */
  	public int getRemainingLife() {
  		
  		if (!super.isMarked()) {
  			
  			return numFrames;
  		}
  		return 0;
  	}
  	
  	/**
  	 * Decrements the remaining life of this Flash. If it reaches zero, this element marks itself for deletion.
  	 */
  	
  	@Override
  	public void update() {
  		
  		super.update();
  		
  		if (numFrames != 0) {
  			
  			numFrames -= 1;
  		}
  		else {
  			
  			super.markForDeletion();
  		}
  	}

}
