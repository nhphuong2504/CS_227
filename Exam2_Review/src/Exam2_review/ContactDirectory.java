package Exam2_review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Exam2_review.Contact;

public class ContactDirectory {
	
	public ArrayList<Contact> contactDir = new ArrayList<Contact>();

	public void addContact(Contact c) {
		
		contactDir.add(c);
	}
	
	public void addFromFile(String filename) throws FileNotFoundException {

		File file = new File(filename);
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();
			Scanner scline = new Scanner(line);

			while(scline.hasNext()) {

				scline.useDelimiter(", ");
				String name = scline.next();
				String number = scline.next();
				Contact c = new Contact(name, number);
				addContact(c);
			}
			scline.close();
	
		}
		sc.close();
	}
	public String lookUp(String name) {
		
		for (int i = 0; i < contactDir.size(); ++i) {
			
			if (name.equals(contactDir.get(i).getName())) {
				
				return contactDir.get(i).getPhoneNumber();
			}
		}
		return null;
	}

}
