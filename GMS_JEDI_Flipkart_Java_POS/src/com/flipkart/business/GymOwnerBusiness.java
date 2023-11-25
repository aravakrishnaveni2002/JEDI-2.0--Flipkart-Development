/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.DAO.*;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerBusinessInterface{
	
	GymOwnerDao gymOwnerDao = new GymOwnerDaoImpl();
	
	public GymOwner getGymOwnerDetails(String gymOwnerEmail) {
		return gymOwnerDao.getGymOwnerDetails(gymOwnerEmail);
	}
	
	public List<Slot> viewAllSlots(int gymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return gymOwnerDao.viewAllSlots(gymCenterId);
	}
	
	public boolean isApproved(String gymOwnerEmail) {
		return gymOwnerDao.isApproved(gymOwnerEmail);
	}

	public void addSlots(int gymCenterId,Slot slot) {
		gymOwnerDao.addSlots(gymCenterId, slot);
		System.out.println("Slot added successfully");
	}
	
	public void addGym(GymCenter gymCenter) {
		gymOwnerDao.addGym(gymCenter);
		System.out.println("GymCenter added successfully");
	}
	
	public List<GymCenter> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all GymCenter");
		return gymOwnerDao.viewAllGymCenters(gymOwnerEmail);	
	}
	
	public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail){
		System.out.println("Listing all approved GymCenter");
		return gymOwnerDao.viewAllApprovedGymCenters(gymOwnerEmail);
	}
	
	
}
