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

	/**

	 This method fetches the details of a gym owner based on the gym owner ID.
	 @param gymOwnerEmail The Email of the gym owner
	 @return The GymOwner object representing the gym owner details
	 */
	public GymOwner getGymOwnerDetails(String gymOwnerEmail) {
		return gymOwnerDao.getGymOwnerDetails(gymOwnerEmail);
	}

	/**

	 This method fetches all the possible slots that a gym owner can select from.
	 @return The list of Slots objects representing the possible slots
	 */
	public List<Slot> viewAllSlots(int gymCenterId){
		System.out.println("Listing all Slots in  GymCenter");
		return gymOwnerDao.viewAllSlots(gymCenterId);
	}

	/**

	 This method checks if a gym owner is approved based on the email address.
	 @param gymOwnerEmail The email address of the gym owner
	 @return true if the gym owner is approved, false otherwise
	 */
	public boolean isApproved(String gymOwnerEmail) {
		return gymOwnerDao.isApproved(gymOwnerEmail);
	}

	/**
	 This method allows a gym owner to add a particular slot for their gym.
	 @param gymCenterId The ID of the gym
	 @param slot The details of the slot to be added
	 */
	public void addSlots(int gymCenterId,Slot slot) {
		gymOwnerDao.addSlots(gymCenterId, slot);
		System.out.println("Slot added successfully");
	}

	/**

	 This method allows a gym owner to add details of a particular gym.
	 @param gymCenter The Gym object representing the gym details
	 */
	public void addGym(GymCenter gymCenter) {
		gymOwnerDao.addGym(gymCenter);
		System.out.println("GymCenter added successfully");
	}

	/**
	 * This method fetches the gym details that belong to a gym owner.
	 * @param gymOwnerEmail The Email of the gym owner
	 * @return The list of GymCenter objects representing the gym details
	 */

	public List<GymCenter> viewAllGymCenters(String gymOwnerEmail){
		System.out.println("Listing all GymCenter");
		return gymOwnerDao.viewAllGymCenters(gymOwnerEmail);	
	}

	/**
	 * This method fetches the all approved gym details that belong to a gym owner.
	 * @param gymOwnerEmail The Email of the gym owner
	 * @return The list of GymCenter objects representing the gym details
	 */
	public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail){
		System.out.println("Listing all approved GymCenter");
		return gymOwnerDao.viewAllApprovedGymCenters(gymOwnerEmail);
	}
	
	
}
