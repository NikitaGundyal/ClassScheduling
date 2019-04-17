package com.neu.edu.doamin;

import java.util.ArrayList;

public class Course {
	private String name =null;
	private String number=null;
	private int maxNumberOfStudents;
	private ArrayList<Instructor> instructors;
	
	public Course(String number, String name, int maxNumberOfStudents, ArrayList<Instructor> instructors) {
		
		this.name = name;
		this.number = number;
		this.maxNumberOfStudents = maxNumberOfStudents;
		this.instructors = instructors;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public int getMaxNumberOfStudents() {
		return maxNumberOfStudents;
	}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}
	
	public String toString() {
		return name;
		
	}
	
}
