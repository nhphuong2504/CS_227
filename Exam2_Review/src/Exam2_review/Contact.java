package Exam2_review;

public class Contact {
	
	String name;
	String phone;
	
	public Contact(String givenName, String givenPhoneNumber) {
		
		name = givenName;
		phone = givenPhoneNumber;

	}
	public String getName() {
		
		return name;
	}
	public String getPhoneNumber() {
		
		return phone;
	}

}
