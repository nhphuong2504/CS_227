package Exam2_review;

public class Horn extends Instrument {
	
	public Horn() {
		
		super("Horn");
	}

	@Override
	public void play() {
		
		System.out.println("blatt");
	}
	
	public void toot() {
		
		System.out.println("toot");
	}
	
	
}
