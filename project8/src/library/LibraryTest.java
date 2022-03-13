package library;

public class LibraryTest {
	
	public static void main(String[] args) {
		
		absBook b = new absBook("Rich dad poor dad");
		
		System.out.println(b.getTitle());
		b.checkIn();
		
		System.out.println(b.isCheckedOut());
	}

}
