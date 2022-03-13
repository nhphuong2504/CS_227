package Exam2_review;

public abstract class Instrument implements Playable {
	
	private String name;
	
	public Instrument(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}
	
}
