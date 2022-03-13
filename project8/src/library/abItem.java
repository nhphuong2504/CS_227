package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class abItem implements Item{
	
	/**
	 * Title of this item.
	 */	
	public String title;
	
	/**
	 * Due date for this item.  This value is null when not checked out.
	 */
	public Date dueDate;
	
	/**
	 * Patron to whom this item is checked out.  This value is null when not checked out.
	 */
	public Patron checkedOutTo;
	
	/**
	 * Replacement cost for this Documentary.
	 */	
	public double replacementCost;
	
	
	/**
	 * Duration of this Documentary, in minutes.
	 */
	public int duration;
	
	public int checkOutDays = 0;
	
	  /**
	   * Checks out this item to the given patron, if possible.
	   * Does nothing if the item is already checked out.
	   * @param p
	   *   Patron to whom to check out the item
	   * @param now
	   *   current date
	   */
	public void checkOut(Patron p, Date now) {
		
	      // use a GregorianCalendar to figure out the Date corresponding to
	      // midnight, 21 days from now
	      GregorianCalendar cal = new GregorianCalendar();
	      cal.setTime(now);
	      cal.add(Calendar.DAY_OF_YEAR, checkOutDays);
	      
	      // always set to 11:59:59 pm on the day it's due
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);     
	      
	      // convert back to Date object
	      dueDate = cal.getTime();
	      
	      checkedOutTo = p;
	}
	
	  /**
	   * Checks in this item.  Does nothing if the item is
	   * not checked out.
	   */
	public void checkIn() {
		
		if (isCheckedOut()) {
			
			checkedOutTo = null;
			dueDate = null;
		}
	}
	
	  /**
	   * Renews this item, if possible.  Does nothing if the item is not checked out.
	   * Does nothing if the item is currently overdue.
	   * @param now
	   *   current date
	   */
	public void renew(Date now) {
		
	}
	
	  /**
	   * Returns the patron to whom this item is checked out, or null
	   * if the item is not checked out.
	   * @return
	   *   patron to whom this item is checked out, or null
	   */
	public Patron getPatron() {
		
		return checkedOutTo;
	}
	
	  /**
	   * Returns the fine owed if this item is overdue, or zero
	   * if the item is not currently overdue.
	   * @param now
	   *   current date
	   * @return
	   *   the fine currently owed
	   */
	public double getFine(Date now) {
		
		return 0;
	}
	
	  /**
	   * Determines whether this item is currently checked out.
	   * @return
	   *   true if this item is checked out, false otherwise
	   */
	public boolean isCheckedOut() {
		
		return dueDate != null;
	}
	
	  /**
	   * Determines whether this item is currently overdue.
	   * @param now
	   *   current date
	   * @return
	   *   true if this item is overdue, false otherwise
	   */
	public boolean isOverdue(Date now) {
		
		if (!isCheckedOut()) {
			
			return false;
		}
		
		return now.after(dueDate);
	}
	
	  /**
	   * Returns the due date for this item, or null if not currently checked out.
	   * @return
	   *   due date for this item, or null
	   */
	public Date getDueDate() {
		
		return dueDate;
	}
	
	  /**
	   * Returns the title of this item.
	   * @return
	   *   title of this item
	   */
	public String getTitle() {
		
		return title;
	}
	
	public int compareTo(Item o) {

		return title.compareTo(o.getTitle());
	}
}
