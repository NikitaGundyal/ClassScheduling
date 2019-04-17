package com.neu.edu;

import java.util.ArrayList;
import com.neu.edu.doamin.Class;

public class Driver {
	
	public static final int POPULATION_SIZE=9;
	public static final double MUTATION_RATE=0.1;
	public static final double CROSSOVER_RATE=0.9;
	public static final int CLASS_SELECTION_SIZE=3;
	public static final int NUM_OF_ELITE_SCHEDULES=1;
	private int scheduleNum=0;
	private int classNumb=1;
	
	private Data data;
	public static void main(String args[]) {
		Driver driver=new Driver();
		driver.data=new Data();
		int generationNumber=0;
		driver.printAvailableData();
		
		System.out.println("generation: " + generationNumber);
		
		GeneticAlgorithm geneticAlgo=new GeneticAlgorithm(driver.data);
		Population population=new Population(driver.POPULATION_SIZE, driver.data).sortByFitness();
		population.getSchedules().forEach(schedule -> System.out.println("   "+driver.scheduleNum++ +"	|" + schedule + "	|"
		+ String.format("%.5f", schedule.getFitness()) + "	|" +schedule.getNumOfConflict()));
		
		driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
		driver.classNumb=1;
		while (population.getSchedules().get(0).getFitness()!=1.0) {
			System.out.println("> generation: " + ++generationNumber);
			System.out.print("  Schedule # |                           ");
			System.out.print("classes [dept,class,room,instructor,meeting-time]      ");
			System.out.println("                         	      | fitness | conflicts");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			population= geneticAlgo.evolve(population).sortByFitness();
			driver.scheduleNum=0;
			population.getSchedules().forEach(schedule-> System.out.println("   " + driver.scheduleNum++  + "    |  "
					+ schedule +" | " + String.format("%.5f", schedule.getFitness()) + " | " + schedule.getNumOfConflict()));
			driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
			driver.classNumb=1;
		}
		
	}
	
	private void printScheduleAsTable(Schedule schedule,int generation) {
		ArrayList<Class> classes=schedule.getClasses();
		System.out.println(" ");
		System.out.println("Class # | dept | Course (number , max # of students) | Room (capacity) | Instructor (id) | Meeting Time (ID) ");
		System.out.print("   ");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		classes.forEach(x-> {
			int majorIndex=data.getDepts().indexOf(x.getDept());
			int coursesindex=data.getCourses().indexOf(x.getCourse());
			int roomsIndex=data.getRooms().indexOf(x.getRoom());
			int instructorsIndex=data.getInstructors().indexOf(x.getInstructor());
			int meetingTimeIndex=data.getMeetingTimes().indexOf(x.getMeetingTime());
			System.out.print("         ");
			System.out.print(String.format("%1$02d",classNumb ) +"  |  ");
			System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName()) + " | ");
			System.out.print(String.format("%1$21s", data.getCourses().get(coursesindex).getName() + 
					" (" + data.getCourses().get(coursesindex).getNumber() + ", " +
					x.getCourse().getMaxNumberOfStudents())+ ")       | ");
			System.out.print(String.format("%1$10s",data.getRooms().get(roomsIndex).getRoomnumber() +" (" +
					x.getRoom().getSeatingCapacity())+ ")      | ");
			System.out.print(String.format("%1$15s",data.getInstructors().get(instructorsIndex).getName() + " (" +
					data.getInstructors().get(instructorsIndex).getId())+ ")     | ");
			System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime() + " (" +data.getMeetingTimes().get(meetingTimeIndex).getId() + ")");
			classNumb++;
		});
		if(schedule.getFitness()==1) System.out.println("> solution found in "+ (generation+1) +"generations");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("  ");
	}
	
	private void printAvailableData() {
		System.out.println("Available departments ==>");
		data.getDepts().forEach(x->System.out.println("name: " + x.getName() + "courses: " +x.getCourses()));
		System.out.println("Available Courses ==>");
		data.getCourses().forEach(x->System.out.println(" course: " +x.getNumber()+ " name: "
		+x.getName()+ " max number of students: " +x.getMaxNumberOfStudents() + " instructor: " + x.getInstructors()));
		
		System.out.println("\n Available rooms: ");
		data.getRooms().forEach(x->System.out.println("room: " + x.getRoomnumber() + " maximum seating capacity: " + x.getSeatingCapacity()));
		System.out.println("\n Available instructor: ");
		data.getInstructors().forEach(x->System.out.println("Instructor id: " + x.getId() + "name: " + x.getName()));
		System.out.println("\n Available Meeting times: ");
		data.getMeetingTimes().forEach(x->System.out.println("id: " + x.getId() + "meeting time: " + x.getTime()));
		
		System.out.println("-------------------------------------------------------");
	}
}
