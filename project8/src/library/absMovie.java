package library;

import java.util.Date;

public class absMovie extends abItem implements Item {
	
	
	public absMovie(String givenTitle, double givenCost, int givenDuration)
	  {
		
		super();
		
	    title = givenTitle;
	    replacementCost = givenCost;
	    duration = givenDuration;
	    
	    checkOutDays = 7;
	  }
	
	public double getFine(Date now) {
		
		if (isCheckedOut() && isOverdue(now))
	    {
	      // how late is it, in milliseconds
	      double elapsed = now.getTime() - dueDate.getTime();
	      
	      // how late is it, in days
	      int millisPerDay = 24 * 60 * 60 * 1000;
	      int daysLate = (int) Math.ceil(elapsed / millisPerDay);
	      
	      // compute the fine
	      double fine = 3 + daysLate * .50;
	      return Math.min(fine, replacementCost);    }
	    else
	    {
	      return 0;
	    }	}

}
