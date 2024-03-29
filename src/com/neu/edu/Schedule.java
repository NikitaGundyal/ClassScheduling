package com.neu.edu;

import java.util.ArrayList;

import com.neu.edu.doamin.Department;
import com.neu.edu.doamin.Class;

public class Schedule {
	
	private ArrayList<Class> classes;
	private int classnum=0;
	private int numOfConflict=0;
	private boolean isFitnessChanged=true;
	private double fitness=-1;
	private Data data;
	
	public Data getData() {
		return data;
	}
	
	public Schedule(Data data) {
		this.data=data;
		classes= new ArrayList<Class>(data.getNumberOfClasses());
	}
	
	public Schedule initialize() {
		new ArrayList<Department>(data.getDepts()).forEach(dept -> {
			dept.getCourses().forEach(course -> {
				Class newClass=new Class(classnum++, dept, course);
				newClass.setMeetingTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
				newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() *Math.random())));
				newClass.setInstructor(data.getInstructors().get((int) (data.getInstructors().size() * Math.random())));
				classes.add(newClass);
			});
		});
		return this;
	}

	public int getNumOfConflict() {
		return numOfConflict;
	}
	
	public ArrayList<Class> getClasses(){
		isFitnessChanged=true;
		return classes;
	}
	
	public double getFitness() {
		if(isFitnessChanged==true) {
			fitness=calculateFitness();
			isFitnessChanged= false;
		}
		return fitness;
	}
	
	private double calculateFitness() {
		numOfConflict=0;
		classes.forEach(x ->{
			if(x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents()) {
				numOfConflict++;
			}
			classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
				if(x.getMeetingTime() == y.getMeetingTime() && x.getId()!=y.getId()) {
					if(x.getRoom()==y.getRoom()) { numOfConflict++; }
					if(x.getInstructor() == y.getInstructor()) {numOfConflict++;}
				}
			});
		});
		return 1/(double)(numOfConflict+1);
	}
	
	public String toString() {
		String returnValue= new String();
		for(int x=0;x<classes.size()-1;x++) returnValue += classes.get(x)+ ",";
		returnValue += classes.get(classes.size()-1);
		return returnValue;
	}
	
	
}
