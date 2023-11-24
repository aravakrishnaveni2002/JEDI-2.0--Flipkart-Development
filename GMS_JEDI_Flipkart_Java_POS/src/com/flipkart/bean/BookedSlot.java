/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class BookedSlot {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private int gymCenterId;
	private int slotId;
	private int userId;
	private String date;

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
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
