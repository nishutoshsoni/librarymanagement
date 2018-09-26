package com.library.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.library.model.Books;
import com.library.model.Users;
import com.library.service.BookData;
import com.library.service.UserData;

public class LibraryManagmentMain {
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		Users admin = new Users("admin", "admin");
		UserData.addNewUser(admin);
		BookData.listOfBooks();
		switchMenu(menu());

	}

	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Login.");
		System.out.println("2. Signup.");
		System.out.println("3. Exit.");
		int choice = sc.nextInt();
		return choice;
	}

	public static void switchMenu(int choice) {
		Scanner sc = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.println("User Name : ");
			String name = sc.nextLine();
			System.out.println("Password : ");
			String password = sc.nextLine();

			if (login(name, password)) {
				System.out.println("Logged in");
				loggedInMenu(name);
			} else {
				System.out.println("Invalid user!");
				switchMenu(menu());
			}
			break;
		case 2:
			System.out.println("Enter user name : ");
			String newUserName = sc.nextLine();
			System.out.println("Enter password : ");
			String newUserPassword = sc.nextLine();
			Users newUser = new Users(newUserName, newUserPassword);
			if (UserData.addNewUser(newUser)) {
				System.out.println(newUserName + " added");
				switchMenu(menu());
			} else {
				System.out.println("User exists, please enter a new username:");
				switchMenu(menu());
			}
			switchMenu(menu());
			break;
		case 3:
			break;
		}
	}

	public static void loggedInMenu(String userName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Make a choice-\n1. Issue");
		System.out.println("2. Reference");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			ArrayList<Books> issueBookList = BookData.getListOfBooks("issue");
			System.out.println("Select any available book-");
			System.out.println("ID  Book Name \t\t\t Is Available");
			for (Books book : issueBookList) {
				System.out.println(book.getId() + ". " + book.getBookName() + "\t\t" + book.isAvailable());
			}
			int bookId = sc.nextInt();
			for (Books book : issueBookList) {
				if (book.getId() == bookId && book.isAvailable()) {
					Date currentDate = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(currentDate);
					c.add(Calendar.DATE, 15);
					Date currentDatePlus15 = c.getTime();
					System.out.println("You have to submit the book by " + dateFormat.format(currentDatePlus15));
					book.setAvailable(false);
					book.setDate(currentDatePlus15);
					System.out.println("Book Issued : ");
					loggedInMenu(userName);
				}
			}
			System.out.println("Book not available, inconvenience regretted.");
			loggedInMenu(userName);
			break;
		case 2:
			ArrayList<Books> referenceBookList = BookData.getListOfBooks("reference");
			System.out.println("Select any available book - ");
			System.out.println("ID  Book Name \t\t\t Is Available");
			for (Books book : referenceBookList) {
				System.out.println(book.getId() + ". " + book.getBookName() + "\t\t" + book.isAvailable());
			}
			int refBookId = sc.nextInt();
			for (Books book : referenceBookList) {
				if (book.getId() == refBookId && book.isAvailable()) {
					System.out.println("You have booked this book " + book.getBookName() + " for reference.");
					book.setAvailable(false);
					loggedInMenu(userName);
				}
			}
			System.out.println("Book not available, inconvenience regretted");
			loggedInMenu(userName);
			break;
		case 3:
			switchMenu(menu());
			break;
		case 4:
			break;
		}
	}

	public static boolean login(String name, String password) {
		UserData isValidUser = new UserData();
		return isValidUser.isValidUser(name, password);
	}
}