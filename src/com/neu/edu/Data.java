package com.neu.edu;

import java.util.ArrayList;
import java.util.Arrays;

import com.neu.edu.doamin.*;

public class Data {

	private ArrayList<Room> rooms;
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;
	private ArrayList<Department> depts;
	private ArrayList<MeetingTime> meetingTimes;
	private int numberOfClasses=0;
	
	
	
	public Data() {
		initialize();
	}


	private Data initialize() {
		
		Room room1= new Room("R1",25);
		Room room2= new Room("R2",45);
		Room room3= new Room("R3",35);
		rooms=new ArrayList<Room>(Arrays.asList(room1,room2,room3));
		
		MeetingTime meetingTime1=new MeetingTime("MT1", "MWF 09:00 - 10:00");
		MeetingTime meetingTime2=new MeetingTime("MT2", "MWF 10:00 - 11:00");
		MeetingTime meetingTime3=new MeetingTime("MT3", "TTH 09:00 - 10:30");
		MeetingTime meetingTime4=new MeetingTime("MT4", "TTH 10:30 - 12:00");
		meetingTimes=new ArrayList<MeetingTime>(Arrays.asList(meetingTime1,meetingTime2,meetingTime3,meetingTime4));
		
		Instructor instructor1= new Instructor("I1", "kal");
		Instructor instructor2= new Instructor("I2", "carrie");
		Instructor instructor3= new Instructor("I3", "vishal");
		Instructor instructor4= new Instructor("I4", "yusuf");
		instructors=new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4));
		
		Course course1=new Course("c1", "325K", 25, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)));
		Course course2=new Course("c2", "319K", 35, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3)));
		Course course3=new Course("c3", "462K", 25, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)));
		Course course4=new Course("c4", "464K", 30, new ArrayList<Instructor>(Arrays.asList(instructor3,instructor4)));
		Course course5=new Course("c5", "360K", 35, new ArrayList<Instructor>(Arrays.asList(instructor4)));
		Course course6=new Course("c6", "303K", 45, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor3)));
		Course course7=new Course("c7", "373K", 45, new ArrayList<Instructor>(Arrays.asList(instructor2,instructor4)));
		courses=new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6,course7));
		
		Department dept1= new Department("Maths", new ArrayList<Course>(Arrays.asList(course1,course3)));
		Department dept2= new Department("EE", new ArrayList<Course>(Arrays.asList(course2,course4,course5)));
		Department dept3= new Department("Physics", new ArrayList<Course>(Arrays.asList(course6,course7)));
		depts=new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3));
		
		
		depts.forEach(x -> numberOfClasses += x.getCourses().size());
		
		return this;
	}


	public ArrayList<Room> getRooms() {
		return rooms;
	}


	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}


	public ArrayList<Course> getCourses() {
		return courses;
	}


	public ArrayList<Department> getDepts() {
		return depts;
	}


	public ArrayList<MeetingTime> getMeetingTimes() {
		return meetingTimes;
	}


	public int getNumberOfClasses() {
		return numberOfClasses;
	}
	
	
	
	
}
