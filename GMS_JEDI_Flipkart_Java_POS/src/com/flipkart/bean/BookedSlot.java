/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class BookedSlot {
	
	
	private int gymCenterId;
	private int slotId;
	private int userId;
	private String date;
	
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
