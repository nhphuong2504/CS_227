package library;

import java.util.Date;

public class absBook extends abItem implements Item {
	
	int renewalCount;
	
	  /**
	   * Constructs a book with the given title.
	   * @param givenTitle
	   */
	  public absBook(String givenTitle)
	  {
		  
		super();
		
		checkOutDays = 21;
	    title = givenTitle;  
	    renewalCount = 0;
	  }


	@Override
	public void renew(Date now) {
		
	    if (isCheckedOut() && !isOverdue(now) && renewalCount < 2)
	    {
	      checkOut(checkedOutTo, dueDate);
	      renewalCount += 1;
	    }  
		
	}

	@Override
	public double getFine(Date now) {
		
		if (isCheckedOut() && isOverdue(now))
	    {
	      // how late is it, in milliseconds
	      double elapsed = now.getTime() - dueDate.getTime();
	      
	      // how late is it, in days
	      int millisPerDay = 24 * 60 * 60 * 1000;
	      int daysLate = (int) Math.ceil(elapsed / millisPerDay);
	      
	      // compute the fine, 25 cents per day
	      return daysLate * .25;
	    }
	    else
	    {
	      return 0;
	    }
	}
}