/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

/**
 * 
 */
public class GymOwnerBusiness {
	
	public GymOwner getGymOwnerDetails(int gymOwnerId) {
		return new GymOwner();
	}
	
	public List<Slot> viewAllSlots(int GymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return new ArrayList<Slot>();
	}
	
	public boolean isApproved() {
		System.out.println("Owner approved Successfully");
		return true;
	}

	public void addSlots(int gymCenterId,String date,Slot slot) {
		System.out.println("Slot added successfully");
		return;
	}
}
