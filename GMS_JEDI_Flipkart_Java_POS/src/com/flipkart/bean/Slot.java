/**
 * 
 */
package com.flipkart.bean;
import java.util.Queue;
import java.util.LinkedList;


/**
 * 
 */
public class Slot {
	
	private int id;
	private String time;
	private int noOfBookedSeats;
	private Queue<Integer> waitingList;

	public Slot() {
		waitingList = new LinkedList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNoOfBookedSeats() {
		return noOfBookedSeats;
	}

	public void setNoOfBookedSeats(int noOfBookedSeats) {
		this.noOfBookedSeats = noOfBookedSeats;
	}
	
	
	
	
	
}
