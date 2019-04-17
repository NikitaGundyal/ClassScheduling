package com.neu.edu.doamin;

public class Instructor {
	private String name;
	private String id;
	public Instructor(String id, String name) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	
	public String toString() {
		return name;
	}
}
