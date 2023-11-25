/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class BookedSlot {

	private int id;
	private int gymCenterId;
	private int slotId;
	private int customerId;
	private String date;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	private String userEmail;
	
	public int getGymCenterId() {
		return gymCenterId;
	}

	public void setGymCenterId(int gymCenterId) {
		this.gymCenterId = gymCenterId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getUserId() {
		return customerId;
	}

	public void setUserId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
