package problems;

public class PracticeExam {
	
	public static void main(String[] args) {
		
		Item i = new Book("Tresure Island");
//		
//		System.out.println(i.getTitle());
//		
////		System.out.println(i.getCheckOutPeriod());
//		
		Book b = new ReferenceBook("How to Bonsai Your Pet");
//		System.out.println(b.getTitle());
//		System.out.println(b.getCheckOutPeriod());
//		
////		LibraryItem li = new LibraryItem("Catch-22");
////		
////		System.out.println(li.getTitle());
//		
//		DVD li = new DVD("Shanghai Surprise", 120);
//		System.out.println(li.getTitle());
//		System.out.println(li.getCheckOutPeriod());
//		System.out.println(li.getDuration());
//		
//		i = b;
//		
//		b = (Book) i;
//		
//		System.out.println(b.getTitle());
//	
//		
		ReferenceBook rb = (ReferenceBook) b;
		System.out.println(rb.getTitle());
//		
//		ReferenceBook rb = (ReferenceBook) new Book("Bif Java");
//		System.out.println(rb.getTitle());
		
//		Item i = new DVD("Tresure Island");
//		System.out.println(i.getTitle());
		
//		LibraryItem li = new LibraryItem("Catch-22");
		
//		Book b = new ReferenceBook("How to Bonsai Your Pet");
//		System.out.println(b.getTitle());
		
//		Book b = (Book) new Item("Big Jva");
//		ReferenceBook rb = (ReferenceBook) b;
//		System.out.println(rb.getTitle());
	}
}



