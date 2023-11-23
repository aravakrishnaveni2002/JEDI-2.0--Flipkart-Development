/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;

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
	
	public boolean isApproved(String gymOwnerEmail) {
		System.out.println("Owner approved Successfully");
		return true;
	}

	public void addSlots(int gymCenterId,Slot slot) {
		System.out.println("Slot added successfully");
		return;
	}
	
	public void addGym(GymCenter gymCenter) {
		System.out.println("Slot added successfully");
		return;
	}
	
	public List<GymCenter> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all GymCenter");
		return new ArrayList<GymCenter>();	
	}
	
	
}
