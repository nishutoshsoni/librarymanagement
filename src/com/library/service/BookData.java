package com.library.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.library.model.Books;

public class BookData {
	private static final ArrayList<Books> referenceBookList = new ArrayList<Books>();
	private static final ArrayList<Books> issueBookList = new ArrayList<Books>();
	static Books book1 = new Books(1, "The Da'Vinci Code", "reference", Date("00/00/0000"), 0, 0, false);
	static Books book2 = new Books(2, "To kill a mocking bird", "reference", Date("00/00/0000"), 0, 0, true);
	static Books book3 = new Books(3, "Anne Frank", "issue", Date("12/02/2018"), 0, 0, true);
	static Books book4 = new Books(4, "Mein Kamph", "reference", Date("00/00/0000"), 0, 0, false);
	static Books book5 = new Books(5, "Immortals of meluha", "issue", Date("12/02/2018"), 0, 0, false);
	static Books book6 = new Books(6, "Naagas", "reference", Date("00/00/0000"), 0, 0, true);
	static Books book7 = new Books(7, "Oath of the vayuputras", "issue", Date("12/02/2018"), 0, 0, false);
	static Books book8 = new Books(8, "One hundred years of solitude", "reference", Date("00/00/0000"), 0, 0, false);
	static Books book9 = new Books(9, "Malgudi Days", "issue", Date("12/02/2018"), 0, 0, true);
	static Books book10 = new Books(10, "The Hobbit", "issue", Date("09/02/2018"), 0, 0, false);

	public static void listOfBooks() {
		referenceBookList.add(book1);
		referenceBookList.add(book2);
		issueBookList.add(book3);
		referenceBookList.add(book4);
		issueBookList.add(book5);
		referenceBookList.add(book6);
		issueBookList.add(book7);
		referenceBookList.add(book8);
		issueBookList.add(book9);
		issueBookList.add(book10);
	}

	public static ArrayList<Books> getListOfBooks(String section) {
		if (section.equals("reference"))
			return referenceBookList;
		else
			return issueBookList;
	}

	public static Date Date(String string) {
		String startDateString = string;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate;
		try {
			startDate = df.parse(startDateString);
			// String newDateString = df.format(startDate);
			return startDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}