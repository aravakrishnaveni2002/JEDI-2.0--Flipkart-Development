package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.List;

public interface GymOwnerBusinessInterface {

    /**

     This method fetches the details of a gym owner based on the gym owner ID.
     @param gymOwnerEmail The Email of the gym owner
     @return The GymOwner object representing the gym owner details
     */
    public GymOwner getGymOwnerDetails(String gymOwnerEmail);

    /**

     This method fetches all the possible slots that a gym owner can select from.
     @return The list of Slots objects representing the possible slots
     */
    public List<Slot> viewAllSlots(int gymCenterId);

    /**

     This method checks if a gym owner is approved based on the email address.
     @param gymOwnerEmail The email address of the gym owner
     @return true if the gym owner is approved, false otherwise
     */
    public boolean isApproved(String gymOwnerEmail);

    /**
     This method allows a gym owner to add a particular slot for their gym.
     @param gymCenterId The ID of the gym
     @param slot The details of the slot to be added
     */
    public void addSlots(int gymCenterId,Slot slot);

    /**

     This method allows a gym owner to add details of a particular gym.
     @param gymCenter The Gym object representing the gym details
     */
    public void addGym(GymCenter gymCenter);

    /**
     * This method fetches the gym details that belong to a gym owner.
     * @param gymOwnerEmail The Email of the gym owner
     * @return The list of GymCenter objects representing the gym details
     */

    public List<GymCenter> viewAllGymCenters(String gymOwnerEmail);

    /**
     * This method fetches the all approved gym details that belong to a gym owner.
     * @param gymOwnerEmail The Email of the gym owner
     * @return The list of GymCenter objects representing the gym details
     */
    public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail);

}
