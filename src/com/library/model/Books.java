package com.library.model;

import java.util.Date;

public class Books {

	private int id = 0;
	private String bookName;

	private String bookSections;

	private Date date = new Date();
	private int time;
	private int duration;
	private boolean available;

	public Books(int id, String bookName, String bookSections, Date date, int time, int duration, boolean available) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookSections = bookSections;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookSections() {
		return bookSections;
	}

	public void setBookSections(String bookSections) {
		this.bookSections = bookSections;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
