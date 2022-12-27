package DTO;

import java.sql.Date;

public class OneDayClass {
	int classNumber;
	String ClassName;
	int price;
	Date day;
	String time;
	int maxStudent;
	String place;
	
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMaxStudent() {
		return maxStudent;
	}
	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
}
