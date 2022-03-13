package lab3;

import static org.junit.Assert.*;

import org.junit.Test;

import balloon.Balloon;

public class BalloonTests {
	// First Balloon should popped when blow pass Maximum Radius.
	// Second Balloon doesn't check if balloon is popped.
	// Third Balloon just doesn't add to radius just sets it.
	// Forth Balloon should not popped when deflate the balloon.
	
	@Test
	public void testBlowPastMax() {
		Balloon b = new Balloon(10);
		b.blow(12);
		assertEquals(true, b.isPopped());
	}
		
	@Test
	public void testBlowingPopped() {
		Balloon b = new Balloon(10);
		b.pop();
		b.blow(2);
		assertEquals(0, b.getRadius());
	}
	

	
	@Test
	public void testDoubleBlow() {
		Balloon b = new Balloon(20);
		b.blow(5);
		b.blow(3);
		assertEquals(8, b.getRadius());
	}

	@Test
	public void deflatePopped() {
		Balloon b = new Balloon(5);
		b.deflate();
		assertEquals(false, b.isPopped());
	}
}
