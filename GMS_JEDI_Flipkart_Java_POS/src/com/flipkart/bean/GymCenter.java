/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class GymCenter {
	
	private int id;
	private String name;
	private String location;
	private int noOfSeats;
	private boolean isApproved;
	private String gymOwnerEmail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public String getGymOwnerEmail() {
		return gymOwnerEmail;
	}

	public void setGymOwnerEmail(String gymOwnerEmail) {
		this.gymOwnerEmail = gymOwnerEmail;
	}

	
}
