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
	private String customerEmail;
	private String date;

	private boolean isActive;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}
}
