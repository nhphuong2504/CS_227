package problems;

class DVD extends LibraryItem {
	
	private int duration; // duration in minutes

	public DVD(String title, int duration) {
		super(title);
		this.duration = duration;
	}

	public String getTitle() {
		return "DVD: " + super.getTitle();
	}

	public int getCheckOutPeriod() {
		return 7; 
	}
	
	public int getDuration() {
		return duration;
	}

	
}
