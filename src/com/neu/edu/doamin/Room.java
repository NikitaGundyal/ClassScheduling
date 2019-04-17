package com.neu.edu.doamin;

public class Room {
	private String roomnumber;
	private int seatingCapacity;
	
	
	public Room(String roomnumber, int seatingCapacity) {
		this.roomnumber = roomnumber;
		this.seatingCapacity = seatingCapacity;
	}


	public String getRoomnumber() {
		return roomnumber;
	}


	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	
	
}
